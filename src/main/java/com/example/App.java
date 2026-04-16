package com.example;

import java.util.HashSet;
import java.util.Set;

public class App {
    private Set<String> activeSessions = new HashSet<>();

    public boolean login(String username) {
        if (username == null || username.isEmpty()) return false;
        return activeSessions.add(username);
    }

    public boolean logout(String username) {
        if (username == null || !activeSessions.contains(username)) return false;
        return activeSessions.remove(username);
    }

    public boolean isSessionActive(String username) {
        return activeSessions.contains(username);
    }

    public int getActiveSessionCount() {
        return activeSessions.size();
    }

    public static void main(String[] args) {
        App system = new App();
        String user = "user123";
        
        system.login(user);
        System.out.println("User logged in: " + system.isSessionActive(user));
        
        system.logout(user);
        System.out.println("User logged out: " + !system.isSessionActive(user));
    }
}
