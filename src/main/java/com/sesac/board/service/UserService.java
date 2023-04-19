package com.sesac.board.service;

import com.sesac.board.entity.User;
import com.sesac.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(User user) {

        return userRepository.save(user).getId();
    }
}
