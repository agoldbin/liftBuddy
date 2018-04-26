package com.aarongoldbin.persistence;

import com.aarongoldbin.entity.Gym;
import com.aarongoldbin.entity.Role;
import com.aarongoldbin.entity.User;
import com.aarongoldbin.entity.Weight;
import com.aarongoldbin.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Role Dao (Using GenericDao)
 *
 * @author agoldbin
 */

public class RoleDaoTest {
    GenericDao genericDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Role.class);

        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

}
