package com.pwcForms.pojo;

import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

public class Departments {

    @Id
    @PartitionKey
    private String slugDepartment;

    private String departmentName;

    private String slugCountry;

    private String slugFirm;

    private String slugLos;

    private boolean active;

    public String getSlugDepartment() {
        return slugDepartment;
    }

    public void setSlugDepartment(String slugDepartment) {
        this.slugDepartment = slugDepartment;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


    public String getSlugCountry() {
        return slugCountry;
    }


    public void setSlugCountry(String slugCountry) {
        this.slugCountry = slugCountry;
    }


    public String getSlugFirm() {
        return slugFirm;
    }


    public void setSlugFirm(String slugFirm) {
        this.slugFirm = slugFirm;
    }


    public String getSlugLos() {
        return slugLos;
    }


    public void setSlugLos(String slugLos) {
        this.slugLos = slugLos;
    }


    public void setActive(boolean active) {
        this.active = active;
    }


    public boolean isActive() {
        return active;
    }



}
