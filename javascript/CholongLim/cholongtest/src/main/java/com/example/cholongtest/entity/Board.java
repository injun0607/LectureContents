package com.example.cholongtest.entity;
// entity 핵심 데이터 관리
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Board {
    private int boardNo;
    // th:field로 맵핑됨
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}




