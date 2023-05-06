package com.sesac.board.service;

import com.sesac.board.comm.Cm_encrypt;
import com.sesac.board.entity.Board;
import com.sesac.board.entity.User;
import com.sesac.board.repository.BoardRepository;
import com.sesac.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Value("${encrypt.key16}")
    private String strKey16;

    /* 전체 Row Select */
    public List<User> doSelectAll() throws Exception {
        // 복호화
        Cm_encrypt cmEncrypt = new Cm_encrypt();

        List<User> list = userRepository.findAll();

        for(User user : list) {
            user.setEmail(cmEncrypt.decryptAes(user.getEmail(), strKey16));
        }

        return list;
    }

    /* One row Select */
    public User doSelectOne(int id) {
        return userRepository.findById(id).get();
    }

    /**
     * 아이디로 조회
     * @param strUserName
     * @throws Exception
     */
    public User doSelectUserName(String strUserName) {
        return userRepository.findByUsername(strUserName);
    }

    /* Insert */
    public void doInsert(User user) throws Exception {

        // 암호화
        Cm_encrypt cmEncrypt = new Cm_encrypt();
        user.setPassword(cmEncrypt.encryptSha256(user.getPassword()));
        user.setEmail((cmEncrypt.encryptAes(user.getEmail(), strKey16)));

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
