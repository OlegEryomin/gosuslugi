package ru.edu.bsu.gosuslugi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.edu.bsu.gosuslugi.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
