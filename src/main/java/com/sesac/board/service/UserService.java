package com.sesac.board.service;

import com.sesac.board.entity.Board;
import com.sesac.board.entity.User;
import com.sesac.board.repository.BoardRepository;
import com.sesac.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /* 전체 Row Select */
    public List<User> doSelectAll() {
        return userRepository.findAll();
    }

    /* One row Select */
    public User doSelectOne(int id) {
        return userRepository.findById(id).get();
    }

    /* Insert */
    public void doInsert(User user) {
        userRepository.save(user);
    }

    /* Update */
    public void doUpdate(User user) {
        userRepository.save(user);
    }

    /* Delete */
    public void doDelete(int id) {
        userRepository.deleteById(id);
    }

}
