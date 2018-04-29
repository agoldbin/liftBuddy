package com.aarongoldbin.persistence;

import com.aarongoldbin.entity.Gym;
import com.aarongoldbin.entity.User;
import com.aarongoldbin.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for GymDao (Using GenericDao)
 *
 * @author agoldbin
 */

class GymDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao genericDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Gym.class);

        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    /**
     * Verify successful retrieval of a gym
     */
    @Test
    void getByIdSuccess() {
        Gym retrievedGym = (Gym) genericDao.getById(1);
        assertEquals("YMCA", retrievedGym.getGymName());
        assertEquals(1, retrievedGym.getId());
    }

    /**
     * Verify successful insert of a gym
     */
    @Test
    void insertSuccess() {
        Gym newGym = new Gym("Gold's Gym");
        int id = genericDao.insert(newGym);
        logger.info("New Gym test: " + newGym);
        assertNotEquals(0,id);
        Gym insertedGym = (Gym) genericDao.getById(id);
        assertEquals("Gold's Gym", insertedGym.getGymName());
    }

    /**
     * Verify successful delete of a gym
     */
    @Test
    void deleteSuccess() {
        logger.info("Deleting Gym test: gym to be deleted: "
                + genericDao.getById(3));
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));

    }

    /**
     * Verify successful retrieval of all gyms
     */
    @Test
    void getAllGymsSuccess() {
        List<Gym> gyms = genericDao.getAll();
        assertEquals(6, gyms.size());
    }

    /**
     * Verify successful update of a gym
     */
    @Test
    void updateSuceess() {
        String newGymName = "Capital Fitness";
        Gym gymToUpdate = (Gym) genericDao.getById(3);
        gymToUpdate.setGymName(newGymName);
        genericDao.saveOrUpdate(gymToUpdate);
        Gym retrivedGym = (Gym) genericDao.getById(3);
        assertEquals(newGymName, retrivedGym.getGymName());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Gym> gyms = genericDao.getByPropertyEqual("gymName", "ymca");
        assertEquals(1, gyms.size());
        assertEquals(1, gyms.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Gym> gyms = genericDao.getByPropertyLike("gymName", "c");
        assertEquals(2, gyms.size());
        assertEquals(3, gyms.get(1).getId());
    }
}