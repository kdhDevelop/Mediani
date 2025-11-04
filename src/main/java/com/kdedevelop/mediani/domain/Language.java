package com.kdedevelop.mediani.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    private short id;
    private String name;

    public void update(String name) {
        this.name = name;
    }
}
