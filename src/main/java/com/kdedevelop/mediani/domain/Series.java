package com.kdedevelop.mediani.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Series {
    private long id;
    private String name;

    public void update(String name) {
        this.name = name;
    }
}
