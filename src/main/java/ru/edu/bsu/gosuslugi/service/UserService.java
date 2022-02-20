package ru.edu.bsu.gosuslugi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.edu.bsu.gosuslugi.entity.UserEntity;
import ru.edu.bsu.gosuslugi.exception.UserAlreadyExistException;
import ru.edu.bsu.gosuslugi.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registratonUser(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Must not new user. Username already exist!");
        } else {
            return userRepo.save(user);
        }
    }
}
