package com.sesac.board.repository;

import com.sesac.board.entity.Board;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    //Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);

//    @Query(value = "SELECT a.*, b.*" +
//            "FROM board.board a, board.user b" +
//            "WHERE a.user_id=b.id", nativeQuery = true)
//    List<Board> findJpql();
}
