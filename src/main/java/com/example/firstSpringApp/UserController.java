package com.example.firstSpringApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    private final UserServices userService;

    @Autowired
    public UserController(UserServices userService) {
        this.userService = userService;
    }
    @GetMapping("/hello")
    public List<UserDAO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/hello/{id}")
    public ResponseEntity<UserDAO> getUserById(@PathVariable int id) {
        UserDAO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/add/user")
    public ResponseEntity<List<UserDAO>> addUser(@RequestBody UserDAO user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping("/update/user/{id}")
    public ResponseEntity<List<UserDAO>> updateUser(@PathVariable int id, @RequestBody UserDAO user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<List<UserDAO>> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
