package com.kdedevelop.mediani.character.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Character {
    private long id;
    private String name;

    public void update(String name) {
        this.name = name;
    }
}
