package com.example.MadelaProject.service;

import com.example.MadelaProject.entity.UserEntity;
import com.example.MadelaProject.exception.BadLoginException;
import com.example.MadelaProject.exception.UserAlreadyExistException;
import com.example.MadelaProject.exception.UserNotFoundException;
import com.example.MadelaProject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
    @Autowired
    private UserRepo userRepo;

    public void registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByLogin(user.getLogin()) != null){
            throw new UserAlreadyExistException("Пользователь с таким логином уже существует");
        }
        userRepo.save(user);
    }

    public void login(UserEntity user) throws BadLoginException {
        if (userRepo.findByLoginAndPassword(user.getLogin(), user.getPassword()) == null){
            throw new BadLoginException("Пользователя с такими данными не существует");
        }
    }

    public void useActivationCode(int code) throws UserNotFoundException {
        if(userRepo.findByConfirmationCode(code) != null){
            userRepo.findByConfirmationCode(code).setIdentified(true);
            userRepo.findByConfirmationCode(code).setConfirmationCode(0);
        } else {
            throw new UserNotFoundException("Пользователя с таким кодом активации нет");
        }
    }
}
