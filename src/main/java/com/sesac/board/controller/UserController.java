package com.sesac.board.controller;

import com.sesac.board.entity.User;
import com.sesac.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // 전체 사용자 조회
    @GetMapping("list")
    public String doUserList(Model model) throws Exception {

        List<User> list = userService.doSelectAll();
        model.addAttribute("list", list);

        return "/user/user_list";
    }

    // 입력
    @GetMapping("/insert")
    public String doInsert() {
        return "/user/user_join";
    }

    // 회원가입
    @PostMapping("/insert_exe")
    public String doInsertExe(@ModelAttribute User user) throws Exception {

        userService.doInsert(user);

        return "redirect:/user/list";

    }
    
    // 회원삭제
    @GetMapping("/delete")
    public String doDelete(@RequestParam(value = "id", defaultValue = "--") String strId) {

        userService.doDelete(Integer.parseInt(strId));
        return "redirect:/user/list";
    }

}
