package ru.edu.bsu.gosuslugi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.edu.bsu.gosuslugi.entity.UserEntity;
import ru.edu.bsu.gosuslugi.exception.*;
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

    public Long deleteUser(Long id) throws UserIdNotTransferredException, UserNotFoundException {
        if (id != null) {
            if (userRepo.findById(id).get() != null) {
                userRepo.deleteById(id);
                return id;
            } else {
                throw new UserNotFoundException("User not found!");
            }

        } else {
            throw new UserIdNotTransferredException("User ID not transferred");
        }

    }
}
