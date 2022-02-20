package ru.edu.bsu.gosuslugi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.edu.bsu.gosuslugi.entity.UserEntity;
import ru.edu.bsu.gosuslugi.exception.DepartmentIdNotTransferredException;
import ru.edu.bsu.gosuslugi.exception.DepartmentsNotFoundException;
import ru.edu.bsu.gosuslugi.exception.UserIdNotTransferredException;
import ru.edu.bsu.gosuslugi.exception.UserNotFoundException;
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

    @GetMapping
    public ResponseEntity getDepartment(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (UserIdNotTransferredException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
