package com.example.MadelaProject.model;

import com.example.MadelaProject.entity.OrganizationEntity;

public class Organization {
    private Long id;
    private String name;
    private String inn;
    private String kpp;
    private String address;
    private String phone;

    public static Organization toModelOne(OrganizationEntity organizationEntity){
        Organization organization = new Organization();
        organization.setId(organizationEntity.getId());
        organization.setName(organizationEntity.getName());
        organization.setInn(organizationEntity.getInn());
        organization.setKpp(organizationEntity.getKpp());
        organization.setAddress(organizationEntity.getAddress());
        organization.setPhone(organizationEntity.getPhone());
        return organization;
    }

    public static Organization toModelOneForList(OrganizationEntity organizationEntity){
        Organization organization = new Organization();
        organization.setId(organizationEntity.getId());
        organization.setName(organizationEntity.getName());
        return organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Organization() {
    }
}
