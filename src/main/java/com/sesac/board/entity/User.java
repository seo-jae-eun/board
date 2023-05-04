package com.sesac.board.entity;

import lombok.*;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 30, unique = true)
    private String username; // 아이디

    @Column(nullable = false, length = 100)
    private String password; // 비밀번호
    
    @Column(nullable = false)
    private String nickname; // 닉네임

    @Column(nullable = false, length = 50)
    private String email; // 이메일

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // 권한 (user or admin)

    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name = "day", updatable = false)
    private LocalDateTime day; // 가입날짜
}
