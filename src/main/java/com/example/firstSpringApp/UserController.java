package com.example.firstSpringApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserServices userService;

    @Autowired
    public UserController(UserServices userService) {
        this.userService = userService;
    }
    @GetMapping("/user-management/users")
    public List<UserEntity> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user-management/users/{id}/action=get")
    public ResponseEntity<UserEntity> getUserById(@PathVariable int id) {
        UserEntity user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user-management/status/action=add")
    public ResponseEntity<List<UserEntity>> addUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping("/user-management/users/{id}/status/action=update")
    public ResponseEntity<List<UserEntity>> updateUser(@PathVariable int id, @RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/user-management/users/{id}/status/action=delete")
    public ResponseEntity<List<UserEntity>> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
