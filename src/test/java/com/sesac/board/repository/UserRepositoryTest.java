package com.sesac.board.repository;

import com.sesac.board.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByUsername() {
        User user = userRepository.findByUsername("root");

        System.out.println(user);
    }
}