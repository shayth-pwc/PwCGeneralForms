package com.pwcForms.controllers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pwcForms.pojo.Los;
import com.pwcForms.repositories.LosRepository;
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

@Controller
@RequestMapping(path = "/los")

public class LosController {

    @Autowired
    private LosRepository losRepository;


    @PostMapping (path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Los> create(@RequestBody Los requestData){
        Los los = losRepository.save(requestData);
        return new ResponseEntity<>(los, HttpStatus.CREATED);
    }


    @PostMapping (path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Los> update(@RequestBody Los requestData){
        Los los = losRepository.save(requestData);
        return new ResponseEntity<>(los, HttpStatus.CREATED);
    }


    @GetMapping(path = "/deactivate/{departmentSlug}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> delete(@PathVariable("departmentSlug") String departmentSlug){
        Optional<Los> los = losRepository.findById(departmentSlug);
        Los param = los.get();
        if (param.isActive()) {
            param.setActive(false);
            losRepository.save(param);
            return new ResponseEntity<String>(""+departmentSlug+" has been deactivated", HttpStatus.OK);
        }
            return new ResponseEntity<>(""+departmentSlug+" is already inactive! ", HttpStatus.NOT_FOUND);
    }

    //activate a department
    @GetMapping (path = "/activate/{departmentSlug}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> activate (@PathVariable("departmentSlug") String departmentSlug){
        Optional<Los> los = losRepository.findById(departmentSlug);
        Los param = los.get();
        if (!param.isActive()) {
            param.setActive(true);
            losRepository.save(param);
            return new ResponseEntity<String>(""+departmentSlug+" has been activated", HttpStatus.OK);
        }
        return new ResponseEntity<>(""+departmentSlug+" is already active !", HttpStatus.NOT_FOUND);
    }


    @GetMapping (path = "/getAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> getAll(){
        Iterable<Los> los = losRepository.findAll();
        Iterator<Los> iterator = los.iterator();
        List<Los> losList = new ArrayList<>();
        while (iterator.hasNext()){

            losList.add(iterator.next());
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(losList);
        return new ResponseEntity<String>(json, HttpStatus.FOUND);
    }

    //get all active departments
    @GetMapping (path = "/getAllActive", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> getAllActive(){
        Iterable<Los> los = losRepository.findAll();
        Iterator<Los> iterator = los.iterator();
        List<Los> losList = new ArrayList<>();
        while (iterator.hasNext()){
            Los los1 = iterator.next();
            if (los1.isActive()){
                losList.add(los1);
            }
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(losList);
        return new ResponseEntity<String>(json, HttpStatus.FOUND);
    }

    @GetMapping (path = "/getById/{departmentSlug}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> getById(@PathVariable("departmentSlug") String departmentSlug){
       Iterable<Los> los = losRepository.findAll();
         Iterator<Los> iterator = los.iterator();
            List<Los> losList = new ArrayList<>();
            while (iterator.hasNext()){
                losList.add(iterator.next());
            }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(losList);
        return new ResponseEntity<String>(json, HttpStatus.FOUND);
    }
}
