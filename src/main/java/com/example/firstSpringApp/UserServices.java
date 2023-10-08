package com.example.firstSpringApp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    private final List<UserEntity> users;

    public UserServices(List<UserEntity> users) {
        this.users = users;
    }
    public List<UserEntity> getAllUsers() {
        return users;
    }

    public UserEntity getUserById(int id) {
        if (id >= 1 && id <= users.size()) {
            return users.get(id - 1);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<UserEntity> addUser(UserEntity user) {
        users.add(user);
        return users;
    }

    public List<UserEntity> updateUser(int id, UserEntity user) {
        if (id >= 1 && id <= users.size()) {
            UserEntity existingUser = users.get(id - 1);
            existingUser.setUserName(user.getUserName());
            return users;
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<UserEntity> deleteUser(int id) {
        if (id >= 1 && id <= users.size()) {
            users.remove(id - 1);
            return users;
        } else {
            throw new RuntimeException("User not found");
        }
    }
}