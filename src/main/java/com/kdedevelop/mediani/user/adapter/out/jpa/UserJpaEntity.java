package com.kdedevelop.mediani.user.adapter.out.jpa;

import com.kdedevelop.mediani.user.domain.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`user`")
public class UserJpaEntity {
    @Id
    @Column(name = "`id`", unique = true, nullable = false)
    private int id;

    @Column(name = "`loginId`", unique = true, nullable = false, length = 255)
    private String loginId;

    @Column(name = "`password`", nullable = false, length = 1000)
    private String password;

    @Column(name = "`name`", nullable = false, length = 255)
    private String name;

    @Column(name = "`expiredAt`", nullable = false)
    private LocalDateTime expiredAt;

    @Column(name = "`createdAt`", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "`updatedAt`", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "`lock`", nullable = false)
    private boolean lock;

    @Column(name = "`enable`", nullable = false)
    private boolean enable;

    @Enumerated(EnumType.STRING)
    @Column(name = "`role`", nullable = false)
    private User.Role role;
}
