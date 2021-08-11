package com.example.demo.service;

import com.example.demo.entity.VueJpaUser;
import com.example.demo.repository.VueJpaLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueJpaLoginServiceImpl implements VueJpaLoginService{

    @Autowired
    private VueJpaLoginRepository repository;

    @Override
    public void register(VueJpaUser user) throws Exception{

        repository.save(user);
    }
}
