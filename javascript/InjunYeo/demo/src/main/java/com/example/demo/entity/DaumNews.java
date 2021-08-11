package com.example.demo.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Data
@NoArgsConstructor
//jpa사용시 필수 어노테이션
@Entity
public class DaumNews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsSeq;

    @Column(length = 20, nullable = false)
    private String newsNo;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String address;

    //빌더를 안써도 생성은된다.
    @Builder
    public DaumNews(String newsNo, String category, String title, String address){
        this.newsNo = newsNo;
        this.address = address;
        this.category = category;
        this.title = title;

    }

}
