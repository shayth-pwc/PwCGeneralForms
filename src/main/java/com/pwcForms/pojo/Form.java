package com.pwcForms.pojo;

import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

public class Form {
    @Id
    @PartitionKey
    private String slugForm;

    private String formName;

    private String slugCountry;

    private String slugFirm;

    private String slugLos;

    private boolean active;

    private String formType;

    private String formUrl;

    private String formDescription;

    private String formVersion;

    private String formVersionDate;

    private String uploadDate;

    private String lastUpdateDate;

    private String uploadUser;

    private String downloadCount;

    private String formSize;

    private String formLanguage;

    private String formCategory;

    private String formSubCategory;

    private String formDepartment;


    public String getSlugForm() {
        return slugForm;
    }

    public void setSlugForm(String slugForm) {
        this.slugForm = slugForm;
    }


    public String getFormName() {
        return formName;
    }


    public void setFormName(String formName) {
        this.formName = formName;
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


    public String getFormType() {
        return formType;
    }


    public void setFormType(String formType) {
        this.formType = formType;
    }


    public String getFormUrl() {
        return formUrl;
    }


    public void setFormUrl(String formUrl) {
        this.formUrl = formUrl;
    }


    public String getFormDescription() {
        return formDescription;
    }


    public void setFormDescription(String formDescription) {
        this.formDescription = formDescription;
    }


    public String getFormVersion() {
        return formVersion;
    }



    public void setFormVersion(String formVersion) {
        this.formVersion = formVersion;
    }


    public String getFormVersionDate() {
        return formVersionDate;
    }


    public void setFormVersionDate(String formVersionDate) {
        this.formVersionDate = formVersionDate;
    }


    public String getUploadDate() {
        return uploadDate;
    }


    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }


    public String getLastUpdateDate() {
        return lastUpdateDate;
    }


    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


    public String getUploadUser() {
        return uploadUser;
    }


    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }


    public String getDownloadCount() {
        return downloadCount;
    }


    public void setDownloadCount(String downloadCount) {
        this.downloadCount = downloadCount;
    }


    public String getFormSize() {
        return formSize;
    }


    public void setFormSize(String formSize) {
        this.formSize = formSize;
    }


    public String getFormLanguage() {
        return formLanguage;
    }


    public void setFormLanguage(String formLanguage) {
        this.formLanguage = formLanguage;
    }


    public String getFormCategory() {
        return formCategory;
    }


    public void setFormCategory(String formCategory) {
        this.formCategory = formCategory;
    }


    public String getFormSubCategory() {
        return formSubCategory;
    }


    public void setFormSubCategory(String formSubCategory) {
        this.formSubCategory = formSubCategory;
    }


    public String getFormDepartment() {
        return formDepartment;
    }


    public void setFormDepartment(String formDepartment) {
        this.formDepartment = formDepartment;
    }


}
