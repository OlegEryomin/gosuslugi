package ru.edu.bsu.gosuslugi.model;

import ru.edu.bsu.gosuslugi.entity.ServiceEntity;


public class ServiceModel {
    private Long id;
    private String name;

    public static ServiceModel toModel(ServiceEntity entity) {
        ServiceModel model = new ServiceModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

    public ServiceModel() {
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
