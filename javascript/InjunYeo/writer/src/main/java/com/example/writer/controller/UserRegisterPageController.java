package com.example.writer.controller;

import com.example.writer.entity.User;
import com.example.writer.repository.UserRepository;
import com.example.writer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user-register")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")

public class UserRegisterPageController {


    @Autowired
    UserService service;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Void> userRegister(@RequestBody User user) throws Exception {
        log.info("user-register(): "+user.getEmail()+user.getName()+user.getPw());

        service.register(user);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/duplicheck")
    public ResponseEntity<Boolean> emailDupliCheck(@RequestBody User user) throws Exception{
        log.info("duplicheck()");
        log.info(user.getEmail());
        Boolean checker = service.duplicheck(user);

        if(checker){
            log.info("you can use email");
        }
        else{
            log.info("you can't use email");
        }

        return new ResponseEntity<Boolean>(checker,HttpStatus.OK);
    }





}
