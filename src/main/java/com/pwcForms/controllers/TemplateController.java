package com.pwcForms.controllers;


import com.pwcForms.pojo.Template;
import com.pwcForms.repositories.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping(path = "/template")

public class TemplateController {

    @Autowired
    private TemplateRepository templateRepository;


    @PostMapping (path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Template> create(@RequestBody Template requestData){
        Template los = templateRepository.save(requestData);
        return new ResponseEntity<>(los, HttpStatus.CREATED);
    }


    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Template> update(@RequestBody Template requestData) {
        Template los = templateRepository.save(requestData);
        return new ResponseEntity<>(los, HttpStatus.CREATED);
    }


    @GetMapping(path = "/delete/{departmentSlug}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("departmentSlug") String departmentSlug) {
        Optional<Template> los = templateRepository.findById(departmentSlug);
        Template param = los.get();
        if (param.isActive()) {
            param.setActive(false);
            return new ResponseEntity<String>("Record Deactivated", HttpStatus.OK);
        }
        return new ResponseEntity<>("No Such Record", HttpStatus.NOT_FOUND);
    }


    @GetMapping (path = "/getAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity <Iterable<Template>> getAll(){
        Iterable<Template> los = templateRepository.findAll();
        return new ResponseEntity<>(los, HttpStatus.OK);
    }


    @GetMapping (path = "/getById/{templateSlug}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Optional<Template>> getById(@PathVariable("templateSlug") String templateSlug){
        Optional<Template> los = templateRepository.findById(templateSlug);
        return new ResponseEntity<>(los, HttpStatus.OK);
    }


    //gwt by uploadUser
    @GetMapping (path = "/getByUploadUser/{uploadUser}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> getByUploadUser(@PathVariable("uploadUser") String uploadUser){
        Iterable<Template> templateIterable = templateRepository.findAll();
        Iterator<Template> templateIterator = templateIterable.iterator();
        List <Template> templateList = new ArrayList<Template>();
        while(templateIterator.hasNext()){
            Template temp = new Template();
            Template templateMetaData = templateIterator.next();
            temp = templateMetaData;

            if(templateMetaData.getUploadUser() != null){
                if(templateMetaData.getUploadUser().equals(uploadUser)){
                    templateMetaData.setSlugTemplate(temp.getSlugTemplate());
                    templateMetaData.setTemplateName(temp.getTemplateName());
                    templateMetaData.setSlugCountry(temp.getSlugCountry());
                    templateMetaData.setSlugFirm(temp.getSlugFirm());
                    templateMetaData.setSlugLos(temp.getSlugLos());
                    templateMetaData.setActive(temp.isActive());
                    templateMetaData.setUploadUser(temp.getUploadUser());
                    templateMetaData.setTemplateCategory(temp.getTemplateCategory());
                    templateMetaData.setTemplateDepartment(temp.getTemplateDepartment());
                    templateMetaData.setTemplateType(temp.getTemplateType());
                    templateMetaData.setDownloadCount(temp.getDownloadCount());
                    templateMetaData.setTemplateDescription(temp.getTemplateDescription());
                    templateMetaData.setTemplateUrl(temp.getTemplateUrl());
                    templateMetaData.setTemplateVersion(temp.getTemplateVersion());
                    templateMetaData.setTemplateVersionDate(temp.getTemplateVersionDate());
                    templateMetaData.setUploadDate(temp.getUploadDate());
                    templateMetaData.setTemplateSubCategory(temp.getTemplateSubCategory());
                    templateMetaData.setTemplateLanguage(temp.getTemplateLanguage());
                    templateList.add(templateMetaData);
                    }

                }
             }
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(templateList);
                return new ResponseEntity<String>(json, HttpStatus.FOUND);

             }




}


