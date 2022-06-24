package com.example.MadelaProject.service;

import com.example.MadelaProject.entity.OfficeEntity;
import com.example.MadelaProject.exception.OfficeNotFoundException;
import com.example.MadelaProject.model.Office;
import com.example.MadelaProject.repository.OfficeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepo officeRepo;

    public List<Office> getList(Long orgId, String name, String phone) throws OfficeNotFoundException {
        try{
            return officeRepo.findAllByOrgIdAndNameIsLikeAndPhoneIsLike(orgId, name, phone).stream().map(Office::toModelOneForList).collect(Collectors.toList());
        } catch (Exception e){
            throw new OfficeNotFoundException("Офисы с таким ID организации не найдены");
        }
    }

    public Office getOne(Long id) throws OfficeNotFoundException {
        try {
            return Office.toModelOne(officeRepo.findById(id).get());
        } catch (Exception e){
            throw new OfficeNotFoundException("Офис с таким ID не найден");
        }
    }

    public void update(OfficeEntity officeEntity){
        OfficeEntity tempOffice = officeRepo.findById(officeEntity.getId()).get();
        tempOffice.setAddress(officeEntity.getAddress());
        tempOffice.setName(officeEntity.getName());
        tempOffice.setPhone(officeEntity.getPhone());
        officeRepo.save(tempOffice);
    }

    public void save(OfficeEntity officeEntity){
        OfficeEntity tempOffice = new OfficeEntity();
        tempOffice.setId(officeEntity.getId());
        tempOffice.setAddress(officeEntity.getAddress());
        tempOffice.setName(officeEntity.getName());
        tempOffice.setPhone(officeEntity.getPhone());
        officeRepo.save(tempOffice);
    }
}
