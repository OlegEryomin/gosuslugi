package ru.edu.bsu.gosuslugi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.edu.bsu.gosuslugi.entity.SubdepartmentEnity;
import ru.edu.bsu.gosuslugi.exception.DepartmentsNotFoundException;
import ru.edu.bsu.gosuslugi.exception.SubdepartmentNameNotTransferredException;
import ru.edu.bsu.gosuslugi.exception.SubdepartmentNotFoundException;
import ru.edu.bsu.gosuslugi.model.Subdepartment;
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
        } catch (SubdepartmentNameNotTransferredException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
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

    @GetMapping
    public ResponseEntity getSubdepartment(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(subdepartmentService.getSubdepartment(id));
        } catch (SubdepartmentNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
