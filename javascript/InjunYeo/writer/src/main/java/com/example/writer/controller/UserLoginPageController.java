package com.example.writer.controller;


import com.example.writer.entity.User;
import com.example.writer.repository.UserRepository;
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

    @Autowired
    UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity<Integer> userLogin(@RequestBody User user) throws Exception{

        log.info("userLogin()! -- Email: "+ user.getEmail()+" ,pw: "+user.getPw());

        Integer res = service.login(user);

        return new ResponseEntity<Integer>(res,HttpStatus.OK);

        //서비스에서 처리하는 더좋은방법이 있지않을까?
        /*
        User maybeUser = repository.findByEmail(user.getEmail());

        if(maybeUser == null){
            log.info("login() - email is not correct");
            return new ResponseEntity<Integer>(1,HttpStatus.OK);
        }

        User loginUser = maybeUser;

        if(!p)

        else{
            log.info("userPw:" +user.getPw());
            log.info("maybeUserPw:"+ maybeUser.getPw());
            if(user.getPw().equals(maybeUser.getPw())){
                log.info("login() success");
                return new ResponseEntity<Integer>(2,HttpStatus.OK);
            }
            else{
                log.info("login() - pw is not correct");
                return new ResponseEntity<Integer>(3,HttpStatus.OK);
            }

         */


    }






}
