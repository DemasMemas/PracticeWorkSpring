package com.example.MadelaProject.model;

import com.example.MadelaProject.entity.UserEntity;

import java.sql.Date;

public class User {
    private Long id;
    private Long officeId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private Long docCode;
    private String docNumber;
    private Date docDate;
    private Long citizenshipCode;
    private Boolean isIdentified;
    private String position;
    private String docName;
    private String citizenshipName;


    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getDocCode() {
        return docCode;
    }

    public void setDocCode(Long docCode) {
        this.docCode = docCode;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Long getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(Long citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User() {
    }

    public static User toModelList(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setMiddleName(entity.getMiddleName());
        model.setLastName(entity.getLastName());
        model.setPosition(entity.getPosition());
        return model;
    }

    public static User toModelOne(UserEntity userEntity){
        User model = new User();
        model.setId(userEntity.getId());
        model.setFirstName(userEntity.getFirstName());
        model.setMiddleName(userEntity.getMiddleName());
        model.setLastName(userEntity.getLastName());
        model.setPosition(userEntity.getPosition());
        model.setDocNumber(userEntity.getDocNumber());
        model.setDocDate(userEntity.getDocDate());
        model.setDocName(userEntity.getDocEntity().getName());
        model.setCitizenshipName(userEntity.getCountryEntity().getName());
        model.setCitizenshipCode(userEntity.getCountryEntity().getCode());
        model.setIdentified(true);
        return model;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
