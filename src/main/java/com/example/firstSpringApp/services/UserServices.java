package com.example.firstSpringApp.services;

import com.example.firstSpringApp.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    private List<User> users;

    public UserServices(List<User> users) {
        this.users = users;
//        users.add(new User("458","adham",456));
//        users.add(new User("89989","ahmed",125));
    }
    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        if (id >= 1 && id <= users.size()) {
            return users.get(id - 1);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<User> addUser(User user) {
        users.add(user);
        return users;
    }

    public List<User> updateUser(int id, User user) {
        if (id >= 1 && id <= users.size()) {
            User existingUser = users.get(id - 1);
            existingUser.setUserName(user.getUserName());
            return users;
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<User> deleteUser(int id) {
        if (id >= 1 && id <= users.size()) {
            users.remove(id - 1);
            return users;
        } else {
            throw new RuntimeException("User not found");
        }
    }
}