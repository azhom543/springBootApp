package com.example.firstSpringApp;

import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloWorld {
    List<User> users = new ArrayList<>(Arrays.asList(
            new User("123","ahmed",01154),
            new User("456","mohamed",585651)
    ));
    private final UserServices userService;

    @Autowired
    public HelloWorld(UserServices userService) {
        this.userService = userService;
    }
//    @GetMapping("/hello")
//    public String printHelloWorld(int id){
//        return "Hello World \n Time now is "+ LocalDateTime.now();
//    }

//    @GetMapping("/hello")
//    public List<User> getUsers(){
//        return users;
//    }
//
//    @GetMapping("hello/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable int id){
//        try{
//            User user = users.get(id - 1);
//            return ResponseEntity.ok(user);
//        }catch (Exception e){
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @PostMapping("/add/user")
//    public ResponseEntity<List<User>> addUser(@RequestBody User user){
//        users.add(user);
//        return ResponseEntity.ok(users);
//    }
//
//    @PutMapping("/update/user/{id}")
//    public ResponseEntity<List<User>> updateUser(@PathVariable int id,@RequestBody User user){
//        try {
//            User editUser = users.get(id - 1);
//            editUser.setUserName(user.getUserName());
//            return ResponseEntity.ok(users);
//        }catch (Exception e){
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/delete/user/{id}")
//    public ResponseEntity<List<User>> deleteUser(@PathVariable int id){
//        try {
//            User editUser = users.remove(id - 1);
//            return ResponseEntity.ok(users);
//        }catch (Exception e){
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @CustomAnnotation("value y")
//    public void myMethod() {
//        //Method implementation
//    }


    @GetMapping("/hello")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/hello/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/add/user")
    public ResponseEntity<List<User>> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping("/update/user/{id}")
    public ResponseEntity<List<User>> updateUser(@PathVariable int id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
