package com.pwcForms.pojo;

import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

public class Template {
    @Id
    @PartitionKey
    private String slugTemplate;

    private String templateName;

    private String slugCountry;

    private String slugFirm;

    private String slugLos;

    private boolean active;

    private String templateType;

    private String templateUrl;

    private String templateDescription;

    private String templateVersion;

    private String templateVersionDate;

    private String uploadDate;

    private String lastUpdateDate;

    private String uploadUser;

    private String downloadCount;

    private String templateSize;

    private String templateLanguage;

    private String templateCategory;

    private String templateSubCategory;

    private String templateDepartment;


    public String getSlugTemplate() {
        return slugTemplate;
    }

    public void setSlugTemplate(String slugForm) {
        this.slugTemplate = slugForm;
    }


    public String getTemplateName() {
        return templateName;
    }


    public void setTemplateName(String templateName) {
        this.templateName = templateName;
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


    public String getTemplateType() {
        return templateType;
    }


    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }


    public String getTemplateUrl() {
        return templateUrl;
    }


    public void setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
    }


    public String getTemplateDescription() {
        return templateDescription;
    }


    public void setTemplateDescription(String templateDescription) {
        this.templateDescription = templateDescription;
    }


    public String getTemplateVersion() {
        return templateVersion;
    }



    public void setTemplateVersion(String templateVersion) {
        this.templateVersion = templateVersion;
    }


    public String getTemplateVersionDate() {
        return templateVersionDate;
    }


    public void setTemplateVersionDate(String templateVersionDate) {
        this.templateVersionDate = templateVersionDate;
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


    public String getTemplateSize() {
        return templateSize;
    }


    public void setTemplateSize(String templateSize) {
        this.templateSize = templateSize;
    }


    public String getTemplateLanguage() {
        return templateLanguage;
    }


    public void setTemplateLanguage(String templateLanguage) {
        this.templateLanguage = templateLanguage;
    }


    public String getTemplateCategory() {
        return templateCategory;
    }


    public void setTemplateCategory(String templateCategory) {
        this.templateCategory = templateCategory;
    }


    public String getTemplateSubCategory() {
        return templateSubCategory;
    }


    public void setTemplateSubCategory(String templateSubCategory) {
        this.templateSubCategory = templateSubCategory;
    }


    public String getTemplateDepartment() {
        return templateDepartment;
    }


    public void setTemplateDepartment(String templateDepartment) {
        this.templateDepartment = templateDepartment;
    }


}
