package com.kdedevelop.mediani.adapter.in.media.dto;

import com.kdedevelop.mediani.domain.Character;
import com.kdedevelop.mediani.domain.Creator;
import com.kdedevelop.mediani.domain.Group;
import com.kdedevelop.mediani.domain.Language;
import com.kdedevelop.mediani.domain.Producer;
import com.kdedevelop.mediani.domain.Series;
import com.kdedevelop.mediani.domain.Tag;
import com.kdedevelop.mediani.domain.Type;

import java.time.LocalDateTime;
import java.util.List;

public record MediaReadResponse(
          long id,
          Type type,
         String cover,
         String title,
         String description,
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
