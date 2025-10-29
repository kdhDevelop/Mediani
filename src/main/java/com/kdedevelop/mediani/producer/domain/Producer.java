package com.kdedevelop.mediani.producer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Producer {
    private long id;
    private String name;

    public void update(String name) {
        this.name = name;
    }
}
