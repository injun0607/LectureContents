package com.example.writer.service;

import com.example.writer.entity.MyPageBoard;

import java.util.List;
import java.util.Optional;

public interface MyPageService {

    public boolean register(MyPageBoard myPageBoard) throws Exception;

    public List<MyPageBoard> list() throws Exception;

    public Optional<MyPageBoard> read(Long boardNo) throws Exception;
}
