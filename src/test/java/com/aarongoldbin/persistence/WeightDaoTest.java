package com.aarongoldbin.persistence;

import com.aarongoldbin.entity.Weight;
import com.aarongoldbin.entity.User;
import com.aarongoldbin.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for WeightDao (Using GenericDao)
 *
 * @author agoldbin
 */

public class WeightDaoTest {

    GenericDao genericDao;
    GenericDao userDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Weight.class);
        userDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("weightTest.sql");
    }

    /**
     * Verify successful retrieval of a weight
     */
    @Test
    void getByIdSuccess() {
        Weight retrievedWeight = (Weight) genericDao.getById(3);
        assertEquals(3, retrievedWeight.getId());
        assertEquals(6, retrievedWeight.getUser().getId());
        assertEquals(200, retrievedWeight.getWeight());
    }

    /**
     * Verify that new weight is successfully added for user 2
     */
    @Test
    void insertNewUserWeightSuccess() {
        User user = (User) userDao.getById(2);
        Weight newWeight = new Weight(user, 150);
        int id = genericDao.insert(newWeight);

        // TODO is this really how I have to set a user's weight?
        user.addWeight(newWeight);
//        newWeight.setUser(user);

        assertNotEquals(0,id);

        Weight insertedWeight = (Weight) genericDao.getById(id);
        assertEquals(150, insertedWeight.getWeight());
        assertEquals(user.getId(), insertedWeight.getUser().getId());

        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful delete of weight
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }

    /**
     * Verify successful retrieval of all weights
     */
    @Test
    void getAllWeightsSuccess() {
        List<Weight> weights = genericDao.getAll();
        assertEquals(9, weights.size());
    }

    /**
     * Verify successful retrieval of weights for user 1
     */
//    @Test
//    void getAllUserWeightsSuccess() {
//        List<Weight> weights = genericDao.getByPropertyLike("weight", "5");
//        assertEquals(4, weights.size());
//    }

    /**
     * Verify successful update of user.
     */
    @Test
    void updateSuceess() {
        int newWeight = 225;
        Weight weightToUpdate = (Weight) genericDao.getById(3);
        weightToUpdate.setWeight(newWeight);
        genericDao.saveOrUpdate(weightToUpdate);
        Weight retrievedWeight = (Weight) genericDao.getById(3);
        assertEquals(newWeight, retrievedWeight.getWeight());
    }

    /**
     * Verify successful get by property (equal match)
     */
//    @Test
//    void getByPropertyEqualSuccess() {
//        List<Weight> weights = genericDao.getByPropertyLike("weightId", "2");
//        assertEquals(1, weights.size());
//        assertEquals(2, weights.get(0).getId());
//
//    }
//
//    /**
//     * Verify successful get by property (like match)
//     */
//    @Test
//    void getByPropertyLikeSuccess() {
//        List<Weight> weights = genericDao.getByPropertyLike("weight", "1");
//        assertEquals(3, weights.size());
//    }
}
