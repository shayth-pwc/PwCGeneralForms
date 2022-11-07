package com.pwcForms.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pwcForms.pojo.Departments;
import com.pwcForms.pojo.Users;
import com.pwcForms.repositories.UsersRepository;
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
@RequestMapping(path = "/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> create(@RequestBody Users requestData){
        Users users = usersRepository.save(requestData);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }


    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> update(@RequestBody Users requestData){
        Users users = usersRepository.save(requestData);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }


    @GetMapping(path = "/deactivate/{userGuid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> delete(@PathVariable("userGuid") String userGuid){
        Optional<Users> users = usersRepository.findById(userGuid);
        Users param = users.get();
        if (param.isActive()) {
            param.setActive(false);
            usersRepository.save(param);
            return new ResponseEntity<>("User With "+userGuid+" has been Deactivated", HttpStatus.OK);
        }
        return new ResponseEntity<>(""+userGuid+" is already inactive !", HttpStatus.OK);
    }

    //activate a user
    @GetMapping(path = "/activate/{userGuid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> activate(@PathVariable("userGuid") String userGuid){
        Optional<Users> users = usersRepository.findById(userGuid);
        Users param = users.get();
        if (!param.isActive()) {
            param.setActive(true);
            usersRepository.save(param);
            return new ResponseEntity<>("User With "+userGuid+" has been Activated", HttpStatus.OK);
        }
        return new ResponseEntity<>(""+userGuid+" is already active !", HttpStatus.OK);
    }


    @GetMapping(path = "/getAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllUsers(){
        Iterable<Users> users = usersRepository.findAll();
        Iterator<Users> iterator = users.iterator();
        List<Users> list = new ArrayList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        return new ResponseEntity<String>(json, HttpStatus.FOUND);
    }


    @GetMapping(path = "/getById/{userGuid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getById(@PathVariable("userGuid") String userGuid){
        Iterable<Users> users = usersRepository.findAll();
        Iterator<Users> iterator = users.iterator();
        List<Users> list = new ArrayList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        return new ResponseEntity<String>(json, HttpStatus.FOUND);
    }



    @GetMapping(path = "/getActiveUsers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getActiveUsers(){
        Iterable<Users> users = usersRepository.findAll();
        Iterator<Users> iterator = users.iterator();
        List<Users> list = new ArrayList<>();
        while (iterator.hasNext()){
            Users user = iterator.next();
            if (user.isActive()){
                list.add(user);
            }
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        return new ResponseEntity<String>(json, HttpStatus.FOUND);
    }



}
