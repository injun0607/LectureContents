package com.example.writer.service;

import com.example.writer.entity.User;
import com.example.writer.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public void register(User user) throws Exception {

        userRepository.save(user);
    }

    @Override
    public boolean duplicheck(User user) throws Exception {
        User maybeEmail = userRepository.findByEmail(user.getEmail());



        if(maybeEmail == null){
            log.info("duplicheck() : True!");
            return true;
        }
        else{
            log.info("duplicheck() : False!");
            return false;
        }

    }
    /*

    @Override
    public Boolean login(User user) throws Exception {

        String maybeUser = userRepository.findByUserId(user.getId());

        if(maybeUser == null){
            log.info("login(): 아이디가 올바르지 않습니다!");
            return false;
        }

        User loginUser = maybeUser.get();


    }

     */
}
