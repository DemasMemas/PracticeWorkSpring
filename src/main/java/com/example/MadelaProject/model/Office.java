package com.example.MadelaProject.model;

import com.example.MadelaProject.entity.OfficeEntity;

public class Office {
    private Long id;
    private Long orgId;
    private String name;
    private String address;
    private String phone;

    public static Office toModelOne(OfficeEntity officeEntity){
        Office office = new Office();
        office.setId(officeEntity.getId());
        office.setName(officeEntity.getName());
        office.setAddress(officeEntity.getAddress());
        office.setPhone(officeEntity.getPhone());
        return office;
    }

    public static Office toModelOneForList(OfficeEntity officeEntity){
        Office office = new Office();
        office.setId(officeEntity.getId());
        office.setName(officeEntity.getName());
        return office;
    }

    public Office() {
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
