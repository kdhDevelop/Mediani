package com.kdedevelop.mediani.user.adapter.out.mybatis;

import com.kdedevelop.mediani.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserMyBatisEntity {
    private int id;
    private String loginId;
    private String password;
    private String name;
    private LocalDateTime expiredAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean lock;
    private boolean enable;
    private User.Role role;
}
