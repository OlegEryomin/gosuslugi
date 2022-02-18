package ru.edu.bsu.gosuslugi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.edu.bsu.gosuslugi.entity.DepartmentEntity;
import ru.edu.bsu.gosuslugi.entity.SubdepartmentEnity;
import ru.edu.bsu.gosuslugi.exception.DepartmentsNotFoundException;
import ru.edu.bsu.gosuslugi.exception.SubdepartmentNameNotTransferredException;
import ru.edu.bsu.gosuslugi.exception.SubdepartmentNotFoundException;
import ru.edu.bsu.gosuslugi.model.Department;
import ru.edu.bsu.gosuslugi.model.Subdepartment;
import ru.edu.bsu.gosuslugi.repository.DepartmetRepo;
import ru.edu.bsu.gosuslugi.repository.SubdepartmentRepo;

@Service
public class SubdepartmentService {
    @Autowired
    private SubdepartmentRepo subdepartmentRepo;
    @Autowired
    private DepartmetRepo departmetRepo;

    public String addSubdepartment(SubdepartmentEnity subdepartment, Long departmentId) throws SubdepartmentNameNotTransferredException{
        if (subdepartment !=null && departmentId !=null) {
            DepartmentEntity department = departmetRepo.findById(departmentId).get();
            subdepartment.setDepartment(department);
            subdepartmentRepo.save(subdepartment);
            return "Create subdepartment success!";
        } else {
            throw new SubdepartmentNameNotTransferredException("Subdepartment name not null!!");
        }

    }

    public Subdepartment completeSubdepartment(Long id, String name) {
        SubdepartmentEnity subdepartment = subdepartmentRepo.findById(id).get();
        subdepartment.setName(name);
        return Subdepartment.toModel(subdepartmentRepo.save(subdepartment));
    }

    public Subdepartment getSubdepartment(Long id) throws SubdepartmentNotFoundException {
        SubdepartmentEnity subdepartment = subdepartmentRepo.findById(id).get();
        if (subdepartment == null) {
            throw new SubdepartmentNotFoundException("Subdepartment not found!");
        } else {
            return Subdepartment.toModel(subdepartment);
        }
    }
}
