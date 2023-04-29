package com.sesac.board.controller;

import com.sesac.board.entity.Board;
import com.sesac.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String doBoardList(Model model) {

        List<Board> list = boardService.doSelectAll();

        model.addAttribute("list", list);

        return "/board/board_list";
    }

}
