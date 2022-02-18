package ru.edu.bsu.gosuslugi.model;

import ru.edu.bsu.gosuslugi.entity.SubdepartmentEnity;

import java.util.List;
import java.util.stream.Collectors;

public class Subdepartment {
    private Long id;
    private String name;
    private List<ServiceModel> services;

    public static Subdepartment toModel(SubdepartmentEnity enity) {
        Subdepartment model = new Subdepartment();
        model.setId(enity.getId());
        model.setName(enity.getName());
        model.setServices(enity.getService().stream().map(ServiceModel::toModel).collect(Collectors.toList()));
        return model;
    }

    public Subdepartment() {
    }

    public List<ServiceModel> getServices() {
        return services;
    }

    public void setServices(List<ServiceModel> services) {
        this.services = services;
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
