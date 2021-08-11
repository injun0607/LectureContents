package com.example.writer.controller;


import com.example.writer.entity.User;
import com.example.writer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user-login")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class UserLoginPageController {

    @Autowired
    UserService service;


    @PostMapping("/login")
    public ResponseEntity<Void> userLogin(@RequestBody User user) throws Exception{

        log.info("userLogin()! -- Email: "+ user.getEmail()+" ,pw: "+user.getPw());

       // Boolean isSuccess = service.login(user);



        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
