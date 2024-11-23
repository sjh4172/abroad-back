package com.backDev.back.repository.qna;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backDev.back.model.qna.Board;

public interface QnaRepository extends JpaRepository<Board, Integer>{

}
