package com.kdedevelop.mediani.user.adapter.out.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class UserMongoEntity {
    @Id
    @Field(name = "id")
    private int id;

    @Field(name = "login_id")
    @Indexed(collation = "ko")
    private String loginId;

    @Field(name = "password")
    private String password;

    @Field(name = "name")
    private String name;

    @Field(name = "expired_at")
    private LocalDateTime expiredAt;

    @Field(name = "created_at")
    private LocalDateTime createdAt;

    @Field(name = "updated_at")
    private LocalDateTime updatedAt;

    @Field(name = "lock")
    private boolean lock;

    @Field(name = "enable")
    private boolean enable;

    @Field(name = "role")
    private String role;
}
