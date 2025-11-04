package com.kdedevelop.mediani.adapter.out.media.mybatis;

import com.kdedevelop.mediani.adapter.out.character.mybatis.CharacterMyBatisEntity;
import com.kdedevelop.mediani.adapter.out.creator.mybatis.CreatorMyBatisEntity;
import com.kdedevelop.mediani.adapter.out.group.mybatis.GroupMyBatisEntity;
import com.kdedevelop.mediani.adapter.out.language.mybatis.LanguageMyBatisEntity;
import com.kdedevelop.mediani.adapter.out.producer.mybatis.ProducerMyBatisEntity;
import com.kdedevelop.mediani.adapter.out.series.mybatis.SeriesMyBatisEntity;
import com.kdedevelop.mediani.adapter.out.tag.mybatis.TagMyBatisEntity;
import com.kdedevelop.mediani.adapter.out.type.mybatis.TypeMyBatisEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MediaMyBatisEntity {
    private long id;
    private TypeMyBatisEntity type;
    private String cover;
    private String title;
    private LanguageMyBatisEntity language;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<CharacterMyBatisEntity> character;
    private List<CreatorMyBatisEntity> creator;
    private List<GroupMyBatisEntity> group;
    private List<ProducerMyBatisEntity> producer;
    private List<SeriesMyBatisEntity> series;
    private List<TagMyBatisEntity> tag;
}
