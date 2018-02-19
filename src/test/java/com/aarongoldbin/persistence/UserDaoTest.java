package com.aarongoldbin.persistence;

import com.aarongoldbin.entity.Gym;
import com.aarongoldbin.entity.User;
import com.aarongoldbin.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// TODO update this file. Was just copypastad from week1, test set up is incorrect

class UserDaoTest {

    UserDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        dao = new UserDao();

        System.out.println("@BeforeEach");
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(3);
        assertEquals("bcurry", retrievedUser.getUserName());
        assertEquals("curryman@yahoo.com", retrievedUser.getUserEmail());
        assertEquals("53704", retrievedUser.getUserLocation());
        assertEquals(3, retrievedUser.getId());
    }

    @Test
    void insertNewUserSuccess() {
        GymDao gymDao = new GymDao();
        Gym gym = gymDao.getByGymId(1);
        User newUser = new User("teddymo@gmail.com","superdupersecret7","TMoney","Ted","Mosby", gym,"53219", LocalDate.parse("1978-04-25"),"5'10",205,"M");
        gym.addUser(newUser);
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("TMoney", insertedUser.getUserName());
        assertEquals("teddymo@gmail.com", insertedUser.getUserEmail());
        assertEquals("53219", insertedUser.getUserLocation());

        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Verify successful update of user.
     */
    @Test
    void updateSuceess() {
        String newLastName = "Davis";
        User userToUpdate = dao.getById(3);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(3);
        assertEquals(newLastName, retrievedUser.getLastName());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
  /*      List<User> users = dao.getByPropertyLike("lastName", "Curry");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getId());
    */
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("userName", "c");
        assertEquals(3, users.size());
    }
}