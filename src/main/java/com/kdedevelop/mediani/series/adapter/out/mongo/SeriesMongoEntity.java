package com.kdedevelop.mediani.series.adapter.out.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "series")
public class SeriesMongoEntity {
    @Id
    @Field(name = "id")
    private long id;

    @Field(name = "name")
    private String name;
}
