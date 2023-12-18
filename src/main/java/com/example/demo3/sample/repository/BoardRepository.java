package com.example.demo3.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo3.sample.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
