package com.example.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.thymeleaf.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
