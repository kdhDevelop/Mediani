package com.kdedevelop.mediani.media.domain;

import com.kdedevelop.mediani.character.domain.Character;
import com.kdedevelop.mediani.creator.domain.Creator;
import com.kdedevelop.mediani.group.domain.Group;
import com.kdedevelop.mediani.language.domain.Language;
import com.kdedevelop.mediani.producer.domain.Producer;
import com.kdedevelop.mediani.series.domain.Series;
import com.kdedevelop.mediani.tag.domain.Tag;
import com.kdedevelop.mediani.type.domain.Type;
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
