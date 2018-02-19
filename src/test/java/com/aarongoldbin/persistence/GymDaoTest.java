package com.aarongoldbin.persistence;

import com.aarongoldbin.entity.Gym;
import com.aarongoldbin.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GymDaoTest {

    GymDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        dao = new GymDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a gym
     */
    @Test
    void getByIdSuccess() {
        Gym retrievedGym = dao.getByGymId(1);
        assertEquals("YMCA", retrievedGym.getGymName());
        assertEquals(1, retrievedGym.getId());
    }

    /**
     * Verify successful insert of a gym
     */
    @Test
    void insertSuccess() {
        Gym newGym = new Gym("Gold's Gym");
        int id = dao.insert(newGym);
        assertNotEquals(0,id);
        Gym insertedGym = dao.getByGymId(id);
        assertEquals("Gold's Gym", insertedGym.getGymName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful delete of a gym
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getByGymId(3));
        assertNull(dao.getByGymId(3));

    }

    /**
     * Verify successful retrieval of all gyms
     */
    @Test
    void getAllSuccess() {
        List<Gym> gyms = dao.getAllGyms();
        assertEquals(6, gyms.size());
    }

    /**
     * Verify successful update of a gym
     */
    @Test
    void updateSuceess() {
        String newGymName = "Capital Fitness";
        Gym gymToUpdate = dao.getByGymId(3);
        gymToUpdate.setGymName(newGymName);
        dao.saveOrUpdate(gymToUpdate);
        Gym retrivedGym = dao.getByGymId(3);
        assertEquals(newGymName, retrivedGym.getGymName());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Gym> gyms = dao.getByPropertyLike("gymName", "ymca");
        assertEquals(1, gyms.size());
        assertEquals(1, gyms.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Gym> gyms = dao.getByPropertyLike("gymName", "c");
        assertEquals(2, gyms.size());
        assertEquals(3, gyms.get(1).getId());
    }
}