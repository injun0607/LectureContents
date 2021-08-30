package com.example.writer.repository;


import com.example.writer.entity.MyPageBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPageBoardRepository extends JpaRepository<MyPageBoard,Long> {



}
