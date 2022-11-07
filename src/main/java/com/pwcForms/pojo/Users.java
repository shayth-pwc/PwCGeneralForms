package com.pwcForms.pojo;

import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

public class Users {

    @Id
    @PartitionKey
    private String userId;

    private String userGuid;

    private String userFullName;


    private String userEmail;

    private String userRole;

    private String userSlugCountry;

    private String userSlugFirm;

    private String userSlugLos;

    private boolean active;

    private String userImage;


    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }


    public String getUserFullName() {
        return userFullName;
    }


    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserSlugCountry(String userSlugCountry) {
        this.userSlugCountry = userSlugCountry;
    }

    public String getUserSlugCountry() {
        return userSlugCountry;
    }

    public void setUserSlugFirm(String userSlugFirm) {
        this.userSlugFirm = userSlugFirm;
    }

    public String getUserSlugFirm() {
        return userSlugFirm;
    }

    public void setUserSlugLos(String userSlugLos) {
        this.userSlugLos = userSlugLos;
    }

    public String getUserSlugLos() {
        return userSlugLos;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }


    public String getUserImage() {
        return userImage;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }








}
