package ru.edu.bsu.gosuslugi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.edu.bsu.gosuslugi.entity.DepartmentEntity;
import ru.edu.bsu.gosuslugi.exception.DepartmentAlreadyExistException;
import ru.edu.bsu.gosuslugi.exception.DepartmentIdNotTransferredException;
import ru.edu.bsu.gosuslugi.exception.DepartmentsNotFoundException;
import ru.edu.bsu.gosuslugi.model.Department;
import ru.edu.bsu.gosuslugi.repository.DepartmetRepo;

@Service
public class DepartmentService {

    @Autowired
    private DepartmetRepo departmetRepo;

    public DepartmentEntity addDepartment(DepartmentEntity department) throws DepartmentAlreadyExistException {
        if (departmetRepo.findByName(department.getName()) != null) {
            throw new DepartmentAlreadyExistException("Must not new department. Department name already exist!");
        } else {
            return departmetRepo.save(department);
        }
    }

    public Iterable<DepartmentEntity> getDepartments() throws DepartmentsNotFoundException {
        Iterable<DepartmentEntity> departments = departmetRepo.findAll();
        if (departments != null) {
            return departments;
        } else {
            throw new DepartmentsNotFoundException("Departments not found!");
        }
    }

    public Department getDepartment(Long id) throws DepartmentsNotFoundException {
        DepartmentEntity department = departmetRepo.findById(id).get();
        if (department == null) {
            throw new DepartmentsNotFoundException("Department not found!");
        } else {
            return Department.toModel(department);
        }
    }

    public Long deleteDepartment(Long id) throws DepartmentIdNotTransferredException, DepartmentsNotFoundException {
        if (id != null) {
            if (departmetRepo.findById(id).get() != null) {
                departmetRepo.deleteById(id);
                return id;
            } else {
                throw new DepartmentsNotFoundException("Department not found!");
            }

        } else {
            throw new DepartmentIdNotTransferredException("Department ID not transferred");
        }

    }
}
