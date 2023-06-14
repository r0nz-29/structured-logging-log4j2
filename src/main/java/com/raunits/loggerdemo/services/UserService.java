package com.raunits.loggerdemo.services;

import com.raunits.loggerdemo.models.User;
import com.raunits.loggerdemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepo repo;

    @Autowired
    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        repo.findAll().forEach(users::add);
        return users;
    }
}
