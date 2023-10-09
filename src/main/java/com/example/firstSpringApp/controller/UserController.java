package com.example.firstSpringApp.controller;

import com.example.firstSpringApp.dto.User;
import com.example.firstSpringApp.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-management")
public class UserController {

    private final UserServices userService;

    @Autowired
    public UserController(UserServices userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/status/action=add")
    public ResponseEntity<List<User>> addUser(@RequestBody @Valid User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<List<User>> updateUser(@PathVariable int id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
