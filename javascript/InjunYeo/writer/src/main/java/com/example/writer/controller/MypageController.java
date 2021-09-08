package com.example.writer.controller;


import com.example.writer.controller.session.UserInfo;
import com.example.writer.entity.MyPageBoard;
import com.example.writer.entity.Tag;
import com.example.writer.entity.User;
import com.example.writer.repository.UserRepository;
import com.example.writer.service.MyPageService;
import com.example.writer.service.TagService;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagService tagService;

    private Long userNo;
    private String tag;


    @PostMapping("/my-page-board-register")
    public ResponseEntity<Boolean> myPageBoardRegister(@RequestBody MypageBoardRequset mypageBoardRequset) throws Exception{

        log.info("myPageBoardRegister() "+mypageBoardRequset.getTitle());
        log.info("tagName : "+mypageBoardRequset.getTag());
        userNo = userRepository.findByEmail(mypageBoardRequset.getWriter()).getUserNo();
        Tag tag = tagService.findTagOrRegister(mypageBoardRequset.getTag());

        MyPageBoard regBoard = new MyPageBoard(mypageBoardRequset.getTitle(), mypageBoardRequset.getWriter(), mypageBoardRequset.getContent());
        regBoard.setUserNo(userNo);
        regBoard.addTag(tag);

        boolean isSuccess = service.register(regBoard);
        log.info("success()!");

        return new ResponseEntity<>(isSuccess,HttpStatus.OK);
    }


    @PostMapping("/my-page-board-list")
    public ResponseEntity<List<MyPageBoard>> postMyPageBoardLists(@RequestBody UserInfo userInfo) throws Exception{

        userNo = userRepository.findByEmail(userInfo.getEmail()).getUserNo();

        log.info("userNo: "+ userNo);

        log.info("getMyPageBoardLists()");


        return new ResponseEntity<>(service.myList(userNo),HttpStatus.OK);
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
