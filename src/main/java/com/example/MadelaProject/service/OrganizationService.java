package com.example.MadelaProject.service;

import com.example.MadelaProject.entity.OrganizationEntity;
import com.example.MadelaProject.exception.OrganizationNotFoundException;
import com.example.MadelaProject.model.Organization;
import com.example.MadelaProject.repository.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepo organizationRepo;

    public Organization getOne(Long id) throws OrganizationNotFoundException {
        try {
            return Organization.toModelOne(organizationRepo.findById(id).get());
        } catch (Exception e){
            throw new OrganizationNotFoundException("Организация не найдена");
        }
    }

    public List<Organization> getAll(String nameFilter, String innFilter) throws OrganizationNotFoundException {
        try {
            if (innFilter == null){
                return organizationRepo.findAllByNameIsLike(nameFilter).stream().map(Organization::toModelOneForList).collect(Collectors.toList());
            } else {
                return organizationRepo.findAllByNameIsLikeAndInnIsLike(nameFilter, innFilter).stream().map(Organization::toModelOneForList).collect(Collectors.toList());
            }
        } catch (Exception e){
            throw new OrganizationNotFoundException("Организации не найдены");
        }
    }

    public void updateOrganization(OrganizationEntity organization){
        OrganizationEntity tempOrg = organizationRepo.findById(organization.getId()).get();
        tempOrg.setName(organization.getName());
        tempOrg.setKpp(organization.getKpp());
        tempOrg.setInn(organization.getInn());
        tempOrg.setAddress(organization.getAddress());
        tempOrg.setPhone(organization.getPhone());
        organizationRepo.save(tempOrg);
    }

    public void save(OrganizationEntity organization){
        organizationRepo.save(organization);
    }
}
