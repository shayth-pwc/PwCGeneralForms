package com.pwcForms.controllers;


import com.azure.cosmos.models.PartitionKey;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pwcForms.pojo.Countries;
import com.pwcForms.repositories.CountriesRepository;
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
@RequestMapping(path = "/countries")

public class CountriesController {

    @Autowired
    private CountriesRepository countriesRepository;


    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Countries> create(@RequestBody Countries requestData){
        Countries countries = countriesRepository.save(requestData);
        return new ResponseEntity<>(countries, HttpStatus.CREATED);
    }


    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Countries> update (@RequestBody Countries requestData){
        Countries countries = countriesRepository.save(requestData);
        return new ResponseEntity<>(countries, HttpStatus.CREATED);
    }


    @GetMapping(path = "/deactivate/{slugCountry}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> delete(@PathVariable ("slugCountry") String slugCountry){
        Optional<Countries> Countries = countriesRepository.findById(slugCountry);
        Countries param = Countries.get();
        if (param.isActive()) {
            param.setActive(false);
            countriesRepository.save(Countries.get());
            return new ResponseEntity<String>(""+slugCountry+" has been deactivated", HttpStatus.OK);
        }
            return new ResponseEntity<>(""+slugCountry+" is already inactive !", HttpStatus.NOT_FOUND);
    }

    //activate a country
       @GetMapping(path = "/activate/{slugCountry}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> activate(@PathVariable ("slugCountry") String slugCountry) {
           Optional<Countries> Countries = countriesRepository.findById(slugCountry);
           Countries param = Countries.get();
           if (!param.isActive()) {
               param.setActive(true);
               countriesRepository.save(Countries.get());
               return new ResponseEntity<String>("" + slugCountry + " has been activated", HttpStatus.OK);
           }
           return new ResponseEntity<>("" + slugCountry + " is already active !", HttpStatus.NOT_FOUND);
       }



    @GetMapping(path = "/getAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> getAllCountries(){
        Iterable<Countries> countries = countriesRepository.findAll();
        Iterator<Countries> iterator = countries.iterator();
        List<Countries> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        return new ResponseEntity<String>(json, HttpStatus.FOUND);
    }

    @GetMapping(path = "/{slugCountry}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Countries> get(@PathVariable ("slugCountry") String slugCountry) {
        Optional<Countries> countries = countriesRepository.findById(slugCountry, new PartitionKey(slugCountry));
        Countries countriesRepository = null;
        if (countries.isPresent()) {
            countriesRepository = countries.get();
            return new ResponseEntity<>(countriesRepository, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
