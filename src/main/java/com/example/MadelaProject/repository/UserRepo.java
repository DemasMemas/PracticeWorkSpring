package com.example.MadelaProject.repository;

import com.example.MadelaProject.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByLogin(String login);
    UserEntity findByLoginAndPassword(String login, String password);
    UserEntity findByConfirmationCode(int code);
    List<UserEntity> findAllByOfficeIdAndFirstNameIsLikeAndLastNameIsLikeAndMiddleNameIsLikeAndPositionIsLike
            (Long OfficeId, String FirstName, String LastName, String MiddleName, String Position);
}
