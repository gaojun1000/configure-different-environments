package com.thejavaside;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class ConfigurationTest {
    @Test
    public void testGetDefaultValue() {
        assertEquals("default", Configuration.getString("db.username"));
        assertEquals("localhost", Configuration.getString("db.host"));
    }

}
