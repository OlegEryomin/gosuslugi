package ru.edu.bsu.gosuslugi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.edu.bsu.gosuslugi.entity.ServiceEntity;

public interface ServiceRepo extends CrudRepository<ServiceEntity, Long> {
}
