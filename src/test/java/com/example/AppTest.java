package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AppTest {
    private App system;

    @BeforeEach
    public void setup() {
        system = new App();
    }

    @Test
    public void testLogin() {
        assertTrue(system.login("testUser"));
        assertTrue(system.isSessionActive("testUser"));
    }

    @Test
    public void testLogout() {
        system.login("testUser");
        assertTrue(system.logout("testUser"));
        assertFalse(system.isSessionActive("testUser"));
    }

    @Test
    public void testLogoutNonExistentUser() {
        assertFalse(system.logout("nonExistent"));
    }

    @Test
    public void testSessionCount() {
        system.login("user1");
        system.login("user2");
        assertEquals(2, system.getActiveSessionCount());
        system.logout("user1");
        assertEquals(1, system.getActiveSessionCount());
    }
}
