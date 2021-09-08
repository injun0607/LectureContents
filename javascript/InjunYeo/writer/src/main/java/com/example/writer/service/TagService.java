package com.example.writer.service;

import com.example.writer.entity.Tag;

public interface TagService {

    public Tag findTagOrRegister(String tagName);
}
