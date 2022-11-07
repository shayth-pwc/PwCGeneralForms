package com.pwcForms.controllers;


import com.azure.cosmos.models.PartitionKey;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pwcForms.pojo.Countries;
import com.pwcForms.pojo.Firms;
import com.pwcForms.repositories.FirmsRepository;
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
@RequestMapping(path = "/firms")
public class FirmsController {

    @Autowired
    private FirmsRepository firmsRepository;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Firms> create(@RequestBody Firms requestData){
        Firms firms = firmsRepository.save(requestData);
        return new ResponseEntity<>(firms, HttpStatus.CREATED);
    }

    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Firms> update(@RequestBody Firms requestData){
        Firms firms = firmsRepository.save(requestData);
        return new ResponseEntity<>(firms, HttpStatus.CREATED);
    }


    @GetMapping (path = "/deactivate/{firmSlug}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete (@PathVariable("firmSlug") String firmSlug){
        Optional<Firms> firms = firmsRepository.findById(firmSlug);
        Firms param = firms.get();
        if (param.isActive()) {
            param.setActive(false);
            firmsRepository.save(firms.get());
            return new ResponseEntity<String>(""+firmSlug+" has been deactivated", HttpStatus.OK);
        }
            return new ResponseEntity<>(""+firmSlug+" is already inactive !", HttpStatus.NOT_FOUND);
    }

    //activate a firm
    @GetMapping (path = "/activate/{firmSlug}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> activate (@PathVariable("firmSlug") String firmSlug){
        Optional<Firms> firms = firmsRepository.findById(firmSlug);
        Firms param = firms.get();
        if (!param.isActive()) {
            param.setActive(true);
            firmsRepository.save(firms.get());
            return new ResponseEntity<String>(""+firmSlug+" has been activated", HttpStatus.OK);
        }
        return new ResponseEntity<>(""+firmSlug+" is already active !", HttpStatus.NOT_FOUND);
    }



    @GetMapping (path = "/getAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllFirms(){
        Iterable <Firms> firms = firmsRepository.findAll();
        Iterator <Firms> iterator = firms.iterator();
        List <Firms> list = new ArrayList<>();

        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        return new ResponseEntity<String>(json, HttpStatus.FOUND);
    }


    @GetMapping (path = "/getAllActive", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllFirmsActive(){
        Iterable <Firms> firms = firmsRepository.findAll();
        Iterator <Firms> iterator = firms.iterator();
        List <Firms> list = new ArrayList<>();

        while (iterator.hasNext()){
            Firms firm = iterator.next();
            if (firm.isActive()){
                list.add(firm);
            }

        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        return new ResponseEntity<String>(json, HttpStatus.FOUND);
    }

    @GetMapping (path = "/{firmSlug}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Firms> getById(@PathVariable("firmSlug") String firmSlug){
        Optional<Firms> firms = firmsRepository.findById(firmSlug, new PartitionKey(firmSlug));
        Firms firmsRepository = null;
        if (firms.isPresent()) {
            firmsRepository = firms.get();
            return new ResponseEntity<>(firmsRepository, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //get firms by slugCountry
    @GetMapping (path = "/getByCountry/{slugCountry}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getByCountry(@PathVariable("slugCountry") String slugCountry){
        Iterable <Firms> firms = firmsRepository.findBySlugCountry(slugCountry);
        Iterator <Firms> iterator = firms.iterator();
        List <Firms> list = new ArrayList<>();

        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        return new ResponseEntity<String>(json, HttpStatus.FOUND);
    }
}
