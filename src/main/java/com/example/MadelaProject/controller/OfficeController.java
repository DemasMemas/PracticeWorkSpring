package com.example.MadelaProject.controller;

import com.example.MadelaProject.entity.OfficeEntity;
import com.example.MadelaProject.exception.OfficeNotFoundException;
import com.example.MadelaProject.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/office")
public class OfficeController {
    @Autowired
    OfficeService officeService;

    @GetMapping("/list/{orgId}")
    public ResponseEntity<?> getList(@PathVariable Long orgId, @RequestBody OfficeEntity officeEntity){
        try {
            return ResponseEntity.ok(officeService.getList(orgId, officeEntity.getName(), officeEntity.getPhone()));
        } catch (OfficeNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.ok(officeService.getOne(id));
        } catch (OfficeNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody OfficeEntity officeEntity){
        try {
            officeService.update(officeEntity);
            return ResponseEntity.ok("success");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody OfficeEntity officeEntity){
        try {
            officeService.save(officeEntity);
            return ResponseEntity.ok("success");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }
}
