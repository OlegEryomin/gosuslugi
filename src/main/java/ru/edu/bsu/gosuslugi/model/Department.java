package ru.edu.bsu.gosuslugi.model;

import ru.edu.bsu.gosuslugi.entity.DepartmentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Department {
    private Long id;
    private String name;
    private List<Subdepartment> subdepartments;

    public static Department toModel(DepartmentEntity entity) {
        Department model = new Department();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setSubdepartments(entity.getSubdepartment().stream().map(Subdepartment::toModel).collect(Collectors.toList()));
        return model;
    }

    public Department() {
    }

    public List<Subdepartment> getSubdepartments() {
        return subdepartments;
    }

    public void setSubdepartments(List<Subdepartment> subdepartments) {
        this.subdepartments = subdepartments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
