package com.sesac.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name = "day", updatable = false)
    private LocalDateTime day;
    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name = "modify_day")
    private LocalDateTime modifyDay;
    private String filename;
    private String filepath;

    // 조인
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
