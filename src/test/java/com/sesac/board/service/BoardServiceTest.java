package com.sesac.board.service;

import com.sesac.board.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Test
    void doInsert() {
        Board board = Board.builder()
                .title("Test Insert 진행")
                .content("내용")
                .day(LocalDateTime.now())
                .build();

        boardService.doInsert(board);
    }

    @Test
    void doUpdate() {
//        Board board = new Board();
//        board.setId(3);
//        board.setTitle("Test Insert 진행");
//        board.setContent("Test Update 진행");
//        board.setDay(LocalDateTime.now());

        Board board = boardService.doSelectOne(3);
        board.setContent("Test Update 진행 - 수정");

        boardService.doUpdate(board);
    }

    @Test
    //@Transactional
    void doDelete() {
        boardService.doDelete(3);
    }
}