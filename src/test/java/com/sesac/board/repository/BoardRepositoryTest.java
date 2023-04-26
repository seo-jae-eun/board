package com.sesac.board.repository;

import com.sesac.board.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository repository;

    @Test
    public void testSelectAll() {
        List<Board> list = repository.findAll();

        for(Board board : list) {
            System.out.println(board.getId());
            System.out.println(board.getDay());
            System.out.println(board.getTitle());
            System.out.println(board.getContent());
        }
    }

    @Test
    public void testSelectOne() {
        Board board = repository.findById(1).get();


        System.out.println(board.getId());
        System.out.println(board.getDay());
        System.out.println(board.getTitle());
        System.out.println(board.getContent());
    }

}