package ru.edu.bsu.gosuslugi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.edu.bsu.gosuslugi.entity.DepartmentEntity;

public interface DepartmetRepo extends CrudRepository<DepartmentEntity, Long> {
    DepartmentEntity findByName(String name);
}
