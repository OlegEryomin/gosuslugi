package ru.edu.bsu.gosuslugi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.edu.bsu.gosuslugi.entity.ServiceEntity;
import ru.edu.bsu.gosuslugi.entity.SubdepartmentEnity;
import ru.edu.bsu.gosuslugi.model.ServiceModel;
import ru.edu.bsu.gosuslugi.repository.ServiceRepo;
import ru.edu.bsu.gosuslugi.repository.SubdepartmentRepo;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepo serviceRepo;
    @Autowired
    private SubdepartmentRepo subdepartmentRepo;

    public ServiceModel addService(ServiceEntity service, Long subdepartmentId) {
        SubdepartmentEnity subdepartment = subdepartmentRepo.findById(subdepartmentId).get();
        service.setSubdepartment(subdepartment);
        return ServiceModel.toModel(serviceRepo.save(service));
    }

}
