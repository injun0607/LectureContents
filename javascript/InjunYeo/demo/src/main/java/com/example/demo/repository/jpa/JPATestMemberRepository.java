
package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JPATestMemberRepository extends JpaRepository<TestMember, Long> {

    @Query("select mem from TestMember mem where mem.userId like %?1%")
    List<TestMember> findByJPQL(String userId);

    /*
    현재 JPA 버전에서는 JPQL 사용시 클래스 변수 명명법을 적용해서 표기하도록 한다
    대표적인 예 -
     */
    @Query("select mem1.memberNo, mem1.password  from TestMember mem1 where mem1.userId like %:userId%")
    List<Object[]> findSpecificByJPQL(@Param("userId") String userId);




}