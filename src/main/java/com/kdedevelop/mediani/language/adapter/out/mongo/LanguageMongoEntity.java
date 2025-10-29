package com.kdedevelop.mediani.language.adapter.out.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "language")
public class LanguageMongoEntity {
    @Id
    @Field(name = "id")
    private short id;

    @Field(name = "name")
    private String name;
}
