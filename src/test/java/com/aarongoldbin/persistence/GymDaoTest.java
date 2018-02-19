package com.aarongoldbin.persistence;

import com.aarongoldbin.entity.Gym;
import com.aarongoldbin.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GymDaoTest {

    GymDao dao;
    GenericDao genericDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        dao = new GymDao();
        genericDao = new GenericDao(Gym.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
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
        assertNotEquals(0,id);
        Gym insertedGym = (Gym) genericDao.getById(id);
        assertEquals("Gold's Gym", insertedGym.getGymName());
    }

    /**
     * Verify successful delete of a gym
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));

    }

    /**
     * Verify successful retrieval of all gyms
     */
    @Test
    void getAllSuccess() {
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
        List<Gym> gyms = genericDao.getByPropertyLike("gymName", "ymca");
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