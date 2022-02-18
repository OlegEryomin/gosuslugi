package ru.edu.bsu.gosuslugi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.edu.bsu.gosuslugi.entity.SubdepartmentEnity;
import ru.edu.bsu.gosuslugi.service.SubdepartmentService;

@RestController
@RequestMapping("/subdepartments")
public class SubdepartmentContoller {

    @Autowired
    private SubdepartmentService subdepartmentService;

    @PostMapping
    public ResponseEntity addSubdepartment(@RequestBody SubdepartmentEnity subdepartment,
                                           @RequestParam Long departmentId) {
        try {
            return ResponseEntity.ok(subdepartmentService.addSubdepartment(subdepartment, departmentId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping
    public ResponseEntity completeSubdepartment(@RequestParam Long id, @RequestParam String name) {
        try {
            return ResponseEntity.ok(subdepartmentService.completeSubdepartment(id, name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
