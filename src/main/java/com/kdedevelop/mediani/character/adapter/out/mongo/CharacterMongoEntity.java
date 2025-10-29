package com.kdedevelop.mediani.character.adapter.out.mongo;

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
@Document(collection = "character")
public class CharacterMongoEntity {
    @Id
    @Field(name = "id")
    private long id;

    @Field(name = "name")
    @Indexed(collation = "ko")
    private String name;
}
