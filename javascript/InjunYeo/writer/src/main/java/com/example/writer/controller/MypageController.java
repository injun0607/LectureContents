package com.example.writer.controller;


import com.example.writer.entity.MyPageBoard;
import com.example.writer.entity.User;
import com.example.writer.service.MyPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user-my")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MypageController {


    @Autowired
    private MyPageService service;



    @PostMapping("/my-page-board-register")
    public ResponseEntity<Boolean> myPageBoardRegister(@RequestBody MyPageBoard myPageBoard) throws Exception{
        log.info("myPageBoardRegister() "+myPageBoard.getTitle());

        boolean isSuccess = service.register(myPageBoard);

        return new ResponseEntity<>(isSuccess,HttpStatus.OK);
    }


    @GetMapping("/my-page-board-list")
    public ResponseEntity<List<MyPageBoard>> getMyPageBoardLists() throws Exception{
        log.info("getMyPageBoardLists()");


        return new ResponseEntity<>(service.list(),HttpStatus.OK);
    }

    @GetMapping("/my-page-board-detail/{boardNo}")
    public ResponseEntity<MyPageBoard> getMyPageBoardRead(@PathVariable("boardNo") Long boardNo) throws Exception{
        log.info("getMyPageBoardRead()");

        log.info("boardNo : "+ boardNo);

        Optional<MyPageBoard> myPageBoard = service.read(boardNo);

        MyPageBoard board = myPageBoard.get();


        log.info("myPageBoardNo : "+ board.getBoardNo());

        return new ResponseEntity<MyPageBoard> (board,HttpStatus.OK);
    }










}
