package com.example.writer.service;

import com.example.writer.entity.MyPageBoard;
import com.example.writer.repository.MyPageBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MyPageServiceImpl implements MyPageService{

    @Autowired
    private MyPageBoardRepository repository;

    @Override
    public boolean register(MyPageBoard myPageBoard) throws Exception{

        log.info("boardRegister()!");
        repository.save(myPageBoard);

        return true;
    }

    @Override
    public List<MyPageBoard> list() throws Exception {

        return repository.findAll();
    }

    @Override
    public Optional<MyPageBoard> read(Long boardNo) throws Exception {
        log.info("read() "+boardNo);


        return repository.findById(boardNo);
    }
}
