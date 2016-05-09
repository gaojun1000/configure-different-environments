package com.thejavaside;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created on 3/28/16.
 */
public class ConfigurationDevTest {

    @BeforeClass
    public static void setup() {
        System.setProperty("env", "dev");
    }
    
    @Test
    public void testGetDevEnvSpecificValue() {
        assertEquals("dev", Configuration.getString("db.username"));
        assertEquals("localhost", Configuration.getString("db.host"));
    }
}
