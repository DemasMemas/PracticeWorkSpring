package com.example.MadelaProject.controller;

import com.example.MadelaProject.entity.UserEntity;
import com.example.MadelaProject.exception.BadLoginException;
import com.example.MadelaProject.exception.UserAlreadyExistException;
import com.example.MadelaProject.exception.UserNotFoundException;
import com.example.MadelaProject.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ApiService apiService;

    @PostMapping("/register")
    public ResponseEntity<?> registration(@RequestBody UserEntity user){
        try {
            int confirmCode =  new Random().nextInt(999999);
            user.setConfirmationCode(confirmCode);
            apiService.registration(user);
            return ResponseEntity.ok("Success. Confirmation code: " + confirmCode);
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity user){
        try {
            apiService.login(user);
            return ResponseEntity.ok("success");
        } catch (BadLoginException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }

    @GetMapping("/activation")
    public ResponseEntity<?> activation(@RequestParam("code") int code){
        try {
            apiService.useActivationCode(code);
            return ResponseEntity.ok("success");
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body("Пользователя с таким кодом подтверждения не найдено");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }
}
