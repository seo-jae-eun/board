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

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    // List 조회
    @GetMapping("/list")
    public String doBoardList(Model model) {

        List<Board> list = boardService.doSelectAll();

        model.addAttribute("list", list);

        return "/board/board_list";
    }

    // 입력
    @GetMapping("/insert")
    public String doInsert() {
        return "/board/board_insert";
    }

    // 등록하기 실행
    @PostMapping("/insert_exe")
    public String doInsertExe(@ModelAttribute Board board) {

        //board.setDay(LocalDateTime.now()); // WAS 시간
        boardService.doInsert(board);

        return "redirect:/board/list";
    }

    // 수정
    @GetMapping("/modify")
    public String doModify(HttpServletRequest request, Model model) {
        String strId = request.getParameter("id");

        Board board = boardService.doSelectOne(Integer.parseInt(strId));

        //request.setAttribute("vo_board", board);
        model.addAttribute("vo_board", board);

        return "/board/board_modify";
    }

    // 수정하기 실행
    @PostMapping("/modify_exe")
    public String doModifyExe(@ModelAttribute Board board) {

        boardService.doInsert(board);

        return "redirect:/board/list";
    }


    // 삭제
    @GetMapping("/delete")
    public String doDelete(@RequestParam(value="id", defaultValue = "--") String strId) {

        boardService.doDelete(Integer.parseInt(strId));

        return "redirect:/board/list";
    }

}
