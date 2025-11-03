package com.kdedevelop.mediani.media.adapter.in.dto;

import com.kdedevelop.mediani.character.domain.Character;
import com.kdedevelop.mediani.creator.domain.Creator;
import com.kdedevelop.mediani.group.domain.Group;
import com.kdedevelop.mediani.language.domain.Language;
import com.kdedevelop.mediani.producer.domain.Producer;
import com.kdedevelop.mediani.series.domain.Series;
import com.kdedevelop.mediani.tag.domain.Tag;
import com.kdedevelop.mediani.type.domain.Type;

import java.time.LocalDateTime;
import java.util.List;

public record MediaReadResponse(
          long id,
          Type type,
         String cover,
         String title,
         Language language,
          LocalDateTime createdAt,
          LocalDateTime updatedAt,
          List<Character> character,
          List<Creator> creator,
          List<Group> group,
          List<Producer> producer,
          List<Series> series,
          List<Tag> tag
) {
}
