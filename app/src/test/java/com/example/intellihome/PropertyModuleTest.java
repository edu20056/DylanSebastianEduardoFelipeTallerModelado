package com.example.intellihome;

import org.junit.Test;
import static org.junit.Assert.*;

public class PropertyModuleTest {

    @Test
    public void testGetTitle_ValidTitle() {
        PropertyModule property = new PropertyModule("Casa en la playa", "Casa", "Coche", "Bonita casa cerca del mar", "4", "1000", "Juan", "19.4326", "-99.1332", null, null, null);
        assertEquals("asa en la playa", property.getTitle());
    }

    @Test
    public void testGetTitle_EmptyTitle() {
        PropertyModule property = new PropertyModule("", "Casa", "Coche", "Bonita casa cerca del mar", "4", "1000", "Juan", "19.4326", "-99.1332", null, null, null);
        assertEquals("", property.getTitle());
    }

    @Test
    public void testGetTitle_LongTitle() {
        PropertyModule property = new PropertyModule("Casa en la playa con un título extremadamente largo que no debería causar problemas", "Casa", "Coche", "Bonita casa cerca del mar", "4", "1000", "Juan", "19.4326", "-99.1332", null, null, null);
        assertEquals("Casa en la playa con un título extremadamente largo que no debería causar problemas", property.getTitle());
    }
}
