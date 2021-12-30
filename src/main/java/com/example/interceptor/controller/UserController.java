package com.example.interceptor.controller;

import com.example.interceptor.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    public static List<User> users = new ArrayList<>();

    static {
        User user1 = new User(1L, "tuan1@test", "test", "hanoi");
        User user2 = new User(2L, "tuan2@test", "test", "hanoi");
        User user3 = new User(3L, "tuan3@test", "test", "hanoi");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody User user) {
        users.add(user);
        return ResponseEntity.ok(user);
    }
}



