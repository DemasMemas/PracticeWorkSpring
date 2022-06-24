package com.example.MadelaProject.service;

import com.example.MadelaProject.entity.UserEntity;
import com.example.MadelaProject.exception.UserAlreadyExistException;
import com.example.MadelaProject.exception.UserNotFoundException;
import com.example.MadelaProject.model.User;
import com.example.MadelaProject.repository.CountryRepo;
import com.example.MadelaProject.repository.DocRepo;
import com.example.MadelaProject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DocRepo docRepo;
    @Autowired
    private CountryRepo countryRepo;

    public void registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByLogin(user.getLogin()) != null){
            throw new UserAlreadyExistException("Пользователь с таким логином уже существует");
        }
        userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        try {
            return User.toModelOne(userRepo.findById(id).get());
        } catch (Exception e){
            throw new UserNotFoundException("Пользователь не найден");
        }
    }

    public List<User> getList(User userEntity) throws UserNotFoundException {
        try {
            return userRepo
                    .findAllByOfficeIdAndFirstNameIsLikeAndLastNameIsLikeAndMiddleNameIsLikeAndPositionIsLike
                            (userEntity.getOfficeId(), userEntity.getFirstName(),
                                    userEntity.getLastName(), userEntity.getMiddleName(), userEntity.getPosition())
                    .stream().map(User::toModelList).filter(user ->
                            (user.getCitizenshipCode().equals(userEntity.getCitizenshipCode())
                                    && (user.getDocCode().equals(userEntity.getDocCode()))))
                    .collect(Collectors.toList());
        } catch (Exception e){
            throw new UserNotFoundException("Пользователи не найдены");
        }
    }

    public void update(User user){
        UserEntity tempUser = userRepo.findById(user.getId()).get();
        tempUser.setFirstName(user.getFirstName());
        tempUser.setMiddleName(user.getMiddleName());
        tempUser.setLastName(user.getLastName());
        tempUser.setPosition(user.getPosition());
        tempUser.setPhone(user.getPhone());
        tempUser.setDocNumber(user.getDocNumber());
        tempUser.setDocDate(user.getDocDate());
        countryRepo.findById(user.getCitizenshipCode()).get().setCode(user.getCitizenshipCode());
        countryRepo.findById(user.getCitizenshipCode()).get().setName(user.getCitizenshipName());
        tempUser.setCountryEntity( countryRepo.findById(user.getCitizenshipCode()).get());
        docRepo.findById(user.getDocCode()).get().setName(user.getDocName());
        tempUser.setDocEntity(docRepo.findById(user.getDocCode()).get());
        userRepo.save(tempUser);
    }

}
