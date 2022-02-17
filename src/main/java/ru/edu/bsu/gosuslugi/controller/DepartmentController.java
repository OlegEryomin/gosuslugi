package ru.edu.bsu.gosuslugi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.edu.bsu.gosuslugi.entity.DepartmentEntity;
import ru.edu.bsu.gosuslugi.exception.DepartmentAlreadyExistException;
import ru.edu.bsu.gosuslugi.exception.DepartmentsNotFoundException;
import ru.edu.bsu.gosuslugi.service.DepartmentService;

@RestController
@RequestMapping(("departments"))
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity addDepartment(@RequestBody DepartmentEntity department) {
        try {
            departmentService.addDepartment(department);
            return ResponseEntity.ok("Department save success");
        } catch (DepartmentAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getDepartments() {
        try {
            return ResponseEntity.ok(departmentService.getDepartments());
        } catch (DepartmentsNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getDepartment(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(departmentService.getDepartment(id));
        } catch (DepartmentsNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }


}
