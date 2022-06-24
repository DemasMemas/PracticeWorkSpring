package com.example.MadelaProject.controller;

import com.example.MadelaProject.entity.UserEntity;
import com.example.MadelaProject.exception.UserAlreadyExistException;
import com.example.MadelaProject.exception.UserNotFoundException;
import com.example.MadelaProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.MadelaProject.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> getList(@RequestBody User userEntity){
        try {
            return ResponseEntity.ok(userService.getList(userEntity));
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("success");
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user){
        try {
            userService.update(user);
            return ResponseEntity.ok("success");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }
}
