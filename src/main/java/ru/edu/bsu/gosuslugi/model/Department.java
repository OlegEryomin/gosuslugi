package ru.edu.bsu.gosuslugi.model;

import ru.edu.bsu.gosuslugi.entity.DepartmentEntity;

public class Department {
    private Long id;
    private String name;

    public static Department toModel(DepartmentEntity entity) {
        Department model = new Department();
        model.setId(entity.getId());
        model.setName(entity.getName());

        return model;
    }

    public Department() {
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
