package com.example.libspring.services;

import com.example.libspring.models.Role;
import com.example.libspring.models.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {
    private HashMap<String, User> userDatabase;

    public UserService() {
        userDatabase = new HashMap<>();
        userDatabase.put("user", new User("user", "user", Role.USER));
        userDatabase.put("admin", new User("admin", "admin", Role.ADMIN));
    }

    public User getUserByLogin(String login) {
        return userDatabase.get(login);
    }
}
