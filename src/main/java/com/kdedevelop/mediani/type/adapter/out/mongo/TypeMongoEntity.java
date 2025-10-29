package com.kdedevelop.mediani.type.adapter.out.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "type")
public class TypeMongoEntity {
    @Id
    @Field(name = "id")
    private short id;

    @Field(name = "name")
    @Indexed(collation = "ko")
    private String name;
}
