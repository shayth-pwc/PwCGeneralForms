package com.pwcForms.controllers;

import com.azure.cosmos.models.PartitionKey;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pwcForms.pojo.Departments;
import com.pwcForms.repositories.DepartmentsRepository;
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
@RequestMapping(path = "/departments")

public class DepartmentsController {

    @Autowired
    private DepartmentsRepository departmentsRepository;


    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Departments> create(@RequestBody Departments requestData){
        Departments departments = departmentsRepository.save(requestData);
        return new ResponseEntity<>(departments, HttpStatus.CREATED);
    }


    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Departments> update(@RequestBody Departments requestData){
        Departments departments = departmentsRepository.save(requestData);
        return new ResponseEntity<>(departments, HttpStatus.CREATED);
    }


    @GetMapping (path = "/deactivate/{slugDepartment}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> delete(@PathVariable("slugDepartment") String slugDepartment){
        Optional<Departments> departments = departmentsRepository.findById(slugDepartment);
        Departments param = departments.get();
        if (param.isActive()) {
            param.setActive(false);
            departmentsRepository.save(param);
            return new ResponseEntity<String>(""+slugDepartment+" has been Deactivated", HttpStatus.OK);
        }

            return new ResponseEntity<>(""+slugDepartment+" is already inactive !", HttpStatus.OK);
    }


    @GetMapping (path = "/activate/{slugDepartment}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> activate(@PathVariable("slugDepartment") String slugDepartment){
        Optional<Departments> departments = departmentsRepository.findById(slugDepartment);
        Departments param = departments.get();
        if (!param.isActive()) {
            param.setActive(true);
            departmentsRepository.save(param);
            return new ResponseEntity<String>(""+slugDepartment+" has been Activated", HttpStatus.OK);
        }

            return new ResponseEntity<>(""+slugDepartment+" is already active !", HttpStatus.OK);
    }


    @GetMapping (path = "/getAllActive", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> getAllActiveDepartments(){
        Iterable<Departments> departments = departmentsRepository.findAll();
        Iterator<Departments> iterator = departments.iterator();
        List<Departments> list = new ArrayList<>();
        while (iterator.hasNext()){
            Departments departments1 = iterator.next();
            if (departments1.isActive()){
                list.add(departments1);
            }
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        return new ResponseEntity<String>(json, HttpStatus.FOUND);
    }

    @GetMapping (path = "/getAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> getAllDepartments(){
        Iterable<Departments> departments = departmentsRepository.findAll();
        Iterator<Departments> iterator = departments.iterator();
        List<Departments> list = new ArrayList<>();
        while (iterator.hasNext()){
            Departments departments1 = iterator.next();
            list.add(departments1);

        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        return new ResponseEntity<String>(json, HttpStatus.FOUND);
    }

    @GetMapping (path = "/{slugDepartment}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Departments> get(@PathVariable("slugDepartment") String slugDepartment){
        Optional<Departments> departments = departmentsRepository.findById(slugDepartment, new PartitionKey(slugDepartment));
        Departments departmentsRepository = null;
        if (departments.isPresent()){
            departmentsRepository = departments.get();
            return new ResponseEntity<>(departmentsRepository, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
