package com.example.websocket.storage;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {

    private Set<String> users;
    private static UserStorage instance;

    private UserStorage() {
        users = new HashSet<>();
    }

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(String userName) throws Exception {
        if (users.contains(userName)){
            throw new Exception("User already exist with login: " + userName);
        }
        users.add(userName);
    }
}
