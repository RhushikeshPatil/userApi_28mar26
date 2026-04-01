package com.rp.projects.controllers;


import com.rp.projects.dto.UserRequest;
import com.rp.projects.model.User;
import com.rp.projects.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest request ) {
        User user = service.createUser(request);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<User>>  getAllUsers(){

        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long  id ){
          User user =   service.getUserById(id);
//sou
          return new ResponseEntity<User>( user , HttpStatus.OK);


    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id ,
                                           @Valid @RequestBody  UserRequest request ){
        User user = service.updateUser(id , request);

        return new ResponseEntity<>(user , HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id ){

        service.deleteUser(id);

        return new  ResponseEntity<>("user deleted successfully !" , HttpStatus.OK);
    }



}
