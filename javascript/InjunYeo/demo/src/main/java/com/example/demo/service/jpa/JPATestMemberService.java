
package com.example.demo.service.jpa;

import com.example.demo.entity.jpa.TestMember;

import java.util.List;
import java.util.Optional;


public interface JPATestMemberService {


    public List<TestMember> findByJPQL() throws Exception;
    public List<Object[]> findSpecificByJPQL() throws Exception;

}

