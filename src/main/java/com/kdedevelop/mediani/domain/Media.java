package com.kdedevelop.mediani.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class Media {
    private final long id;
    private final Type type;
    private String cover;
    private String title;
    private String description;
    private Language language;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final List<Character> character;
    private final List<Creator> creator;
    private final List<Group> group;
    private final List<Producer> producer;
    private final List<Series> series;
    private final List<Tag> tag;
}
