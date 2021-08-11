package com.example.writer.service;

import com.example.writer.entity.User;

public interface UserService {

    public void register(User user) throws Exception;

    public boolean duplicheck(User user) throws Exception;

    //public boolean login(User user) throws Exception;
}
