package com.sesac.board.controller.api;

import com.sesac.board.dto.UserSaveRequestDto;
import com.sesac.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

//    private final UserService userService;
//
//    @PostMapping("/api/v1/user")
//    public Integer save(@RequestBody UserSaveRequestDto userSaveRequestDto) {
//        return userService.save(userSaveRequestDto.toEntity());
//    }
}
