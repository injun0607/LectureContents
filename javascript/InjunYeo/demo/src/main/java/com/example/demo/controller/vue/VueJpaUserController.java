package com.example.demo.controller.vue;

import com.example.demo.entity.VueJpaUser;
import com.example.demo.service.VueJpaLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/jpa-user")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")


public class VueJpaUserController {

    @Autowired
    VueJpaLoginService service;

    @PostMapping("/register")
    public ResponseEntity<VueJpaUser> register(@Validated @RequestBody VueJpaUser user) throws Exception{
        log.info("jpaUserRegister from vue()");

        service.register(user);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }


}
