package ru.edu.bsu.gosuslugi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.edu.bsu.gosuslugi.entity.DepartmentEntity;
import ru.edu.bsu.gosuslugi.entity.SubdepartmentEnity;
import ru.edu.bsu.gosuslugi.model.Subdepartment;
import ru.edu.bsu.gosuslugi.repository.DepartmetRepo;
import ru.edu.bsu.gosuslugi.repository.SubdepartmentRepo;

@Service
public class SubdepartmentService {
    @Autowired
    private SubdepartmentRepo subdepartmentRepo;
    @Autowired
    private DepartmetRepo departmetRepo;

    public Subdepartment addSubdepartment(SubdepartmentEnity subdepartment, Long departmentId) {
        DepartmentEntity department = departmetRepo.findById(departmentId).get();
        subdepartment.setDepartment(department);
        return Subdepartment.toModel(subdepartmentRepo.save(subdepartment));
    }

    public Subdepartment completeSubdepartment(Long id, String name) {
        SubdepartmentEnity subdepartment = subdepartmentRepo.findById(id).get();
        subdepartment.setName(name);
        return Subdepartment.toModel(subdepartmentRepo.save(subdepartment));
    }
}
