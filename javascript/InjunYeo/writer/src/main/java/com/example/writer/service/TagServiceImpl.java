package com.example.writer.service;

import com.example.writer.entity.Tag;
import com.example.writer.repository.TagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class TagServiceImpl implements TagService{

    @Autowired
    TagRepository repository;

    @Override
    public Tag findTagOrRegister(String tagName) {

        Tag maybeTag = repository.findByTagName(tagName);

        if(maybeTag != null){
            return maybeTag;
        }
        else{
            repository.save(new Tag(tagName));
            maybeTag = repository.findByTagName(tagName);
            return maybeTag;
        }

    }
}
