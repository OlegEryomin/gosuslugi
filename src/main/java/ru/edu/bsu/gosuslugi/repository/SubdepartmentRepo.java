package ru.edu.bsu.gosuslugi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.edu.bsu.gosuslugi.entity.SubdepartmentEnity;

public interface SubdepartmentRepo extends CrudRepository<SubdepartmentEnity, Long> {
}
