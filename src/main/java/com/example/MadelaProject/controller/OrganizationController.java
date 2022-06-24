package com.example.MadelaProject.controller;

import com.example.MadelaProject.entity.OrganizationEntity;
import com.example.MadelaProject.exception.OrganizationNotFoundException;
import com.example.MadelaProject.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.ok(organizationService.getOne(id));
        } catch (OrganizationNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }

    @PostMapping("/list")
    public ResponseEntity<?> getList(@RequestBody OrganizationEntity organization){
        try {
            return ResponseEntity.ok(organizationService.getAll(organization.getName(), organization.getInn()));
        } catch (OrganizationNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody OrganizationEntity organization){
        try {
            organizationService.updateOrganization(organization);
            return ResponseEntity.ok("success");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> makeNew(@RequestBody OrganizationEntity organization){
        try {
            organizationService.save(organization);
            return ResponseEntity.ok("success");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка " + e.getMessage());
        }
    }
}
