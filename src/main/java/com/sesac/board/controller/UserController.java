package com.sesac.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    // 회원가입
    @GetMapping("/auth/join")
    public String userSave() {

        return "layout/user/usersave";
    }

}
