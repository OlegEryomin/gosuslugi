package ru.edu.bsu.gosuslugi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.edu.bsu.gosuslugi.entity.ServiceEntity;
import ru.edu.bsu.gosuslugi.service.ServiceService;

@RestController
@RequestMapping("service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity addSubdepartment(@RequestBody ServiceEntity service,
                                           @RequestParam Long subdepartmentId) {
        try {
            return ResponseEntity.ok(serviceService.addService(service, subdepartmentId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
