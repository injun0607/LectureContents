package com.example.demo.repository;

import com.example.demo.entity.VueJpaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueJpaLoginRepository extends JpaRepository<VueJpaUser, Long> {

}
