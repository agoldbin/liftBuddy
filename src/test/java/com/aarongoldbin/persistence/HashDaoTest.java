package com.aarongoldbin.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HashDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    // Version: Apache Tomcat (TomEE)/8.5.3 (7.0.1)
    //See http://tomcat.apache.org/tomcat-8.0-doc/realm-howto.html#Digested_Passwords
    public void testHash() throws Exception {
        String stringToHash = "testing";
//        String hashedString = RealmBase.Digest(stringToHash,"sha-256", "UTF-8");
//        assertEquals(hashedString, "dc724af18fbdd4e59189f5fe768a5f8311527050");
    }

}