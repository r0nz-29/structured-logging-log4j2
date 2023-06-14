package com.raunits.loggerdemo.controllers;

import com.raunits.loggerdemo.models.User;
import com.raunits.loggerdemo.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DemoController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService service) {
        this.userService = service;
    }

    @GetMapping("/api/users")
    public List<User> getUsers() {
        List<User> users = userService.getAll();
        String small = "raunit";

        try {
            char ch = small.charAt(99);
        } catch (Exception e) {
            LoggerFactory.getLogger(getClass()).error(e.toString());
        }

        return users;
    }

    @GetMapping("/api/multipleParamsDemo")
    public String multipleParams(@RequestParam Map<String, String> reqParams) {
        LoggerFactory.getLogger(getClass()).info(reqParams.toString());
        return "Done";
    }

    @GetMapping("/api/user/{id}")
    public String getUser(@PathVariable String id) {
        // TODO: Implement logic to fetch user from the database and return the result
        return "User " + id;
    }

    @PostMapping("/api/user")
    public String createUser(@RequestBody String fullName) {
        // TODO: Implement logic to create a new user in the database
        return "New user created";
    }
}
