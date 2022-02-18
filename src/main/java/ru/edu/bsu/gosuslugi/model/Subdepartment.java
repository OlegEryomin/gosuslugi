package ru.edu.bsu.gosuslugi.model;

import ru.edu.bsu.gosuslugi.entity.SubdepartmentEnity;

public class Subdepartment {
    private Long id;
    private String name;

    public static Subdepartment toModel(SubdepartmentEnity enity) {
        Subdepartment model = new Subdepartment();
        model.setId(enity.getId());
        model.setName(enity.getName());
        return model;
    }

    public Subdepartment() {
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
