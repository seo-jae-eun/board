package com.sesac.board.service;

import com.sesac.board.entity.Board;
import com.sesac.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    /* 전체 Row Select */
    public List<Board> doSelectAll() {
        //return boardRepository.findJpql();
        return boardRepository.findAll();
    }

    /* One row Select */
    public Board doSelectOne(int id) {
        return boardRepository.findById(id).get();
    }

    /* Insert */
    public void doInsert(Board board) {
        boardRepository.save(board);
    }

    /* Update */
    public void doUpdate(Board board) {
        boardRepository.save(board);
    }

    /* Delete */
    public void doDelete(int id) {
        boardRepository.deleteById(id);
    }

}
