package com.kdedevelop.mediani.creator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Creator {
    private long id;
    private String name;

    public void update(String name) {
        this.name = name;
    }
}
