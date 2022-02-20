package ru.edu.bsu.gosuslugi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.bsu.gosuslugi.entity.UserEntity;
import ru.edu.bsu.gosuslugi.service.UserService;

@RestController
@RequestMapping(("users"))
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registarionUser(@RequestBody UserEntity user) {
        try {
            userService.registratonUser(user);
            return ResponseEntity.ok("Registration success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
