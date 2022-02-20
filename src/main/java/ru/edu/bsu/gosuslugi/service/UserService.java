package ru.edu.bsu.gosuslugi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.edu.bsu.gosuslugi.entity.DepartmentEntity;
import ru.edu.bsu.gosuslugi.entity.UserEntity;
import ru.edu.bsu.gosuslugi.exception.DepartmentsNotFoundException;
import ru.edu.bsu.gosuslugi.exception.UserAlreadyExistException;
import ru.edu.bsu.gosuslugi.exception.UserNotFoundException;
import ru.edu.bsu.gosuslugi.model.Department;
import ru.edu.bsu.gosuslugi.model.User;
import ru.edu.bsu.gosuslugi.repository.UserRepo;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public UserEntity registratonUser(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Must not new user. Username already exist!");
        } else {
            UserEntity userSave = new UserEntity();
            userSave.setId(user.getId());
            userSave.setUsername(user.getUsername());
            MessageDigestPasswordEncoder md5 = new MessageDigestPasswordEncoder("md5");
            userSave.setPassword(md5.encode(user.getPassword()));

            return userRepo.save(userSave);
        }
    }

    public User getUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Department not found!");
        } else {
            return User.toModel(user);
        }
    }
}
