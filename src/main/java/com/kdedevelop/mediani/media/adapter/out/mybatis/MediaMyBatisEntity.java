package com.kdedevelop.mediani.media.adapter.out.mybatis;

import com.kdedevelop.mediani.character.adapter.out.mybatis.CharacterMyBatisEntity;
import com.kdedevelop.mediani.creator.adapter.out.mybatis.CreatorMyBatisEntity;
import com.kdedevelop.mediani.group.adapter.out.mybatis.GroupMyBatisEntity;
import com.kdedevelop.mediani.language.adapter.out.mybatis.LanguageMyBatisEntity;
import com.kdedevelop.mediani.producer.adapter.out.mybatis.ProducerMyBatisEntity;
import com.kdedevelop.mediani.series.adapter.out.mybatis.SeriesMyBatisEntity;
import com.kdedevelop.mediani.tag.adapter.out.mybatis.TagMyBatisEntity;
import com.kdedevelop.mediani.type.adapter.out.mybatis.TypeMyBatisEntity;
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
