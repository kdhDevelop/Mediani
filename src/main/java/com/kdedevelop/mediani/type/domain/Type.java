package com.kdedevelop.mediani.type.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private short id;
    private String name;

    public void update(String name) {
        this.name = name;
    }
}
