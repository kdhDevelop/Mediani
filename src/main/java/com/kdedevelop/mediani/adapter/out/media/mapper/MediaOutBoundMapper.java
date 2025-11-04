package com.kdedevelop.mediani.adapter.out.media.mapper;

import com.kdedevelop.mediani.adapter.out.character.mapper.CharacterOutBoundMapper;
import com.kdedevelop.mediani.adapter.out.creator.mapper.CreatorOutBoundMapper;
import com.kdedevelop.mediani.adapter.out.group.mapper.GroupOutBoundMapper;
import com.kdedevelop.mediani.adapter.out.language.mapper.LanguageOutBoundMapper;
import com.kdedevelop.mediani.adapter.out.media.mybatis.MediaMyBatisEntity;
import com.kdedevelop.mediani.domain.Media;
import com.kdedevelop.mediani.adapter.out.producer.mapper.ProducerOutBoundMapper;
import com.kdedevelop.mediani.adapter.out.series.mapper.SeriesOutBoundMapper;
import com.kdedevelop.mediani.adapter.out.tag.mapper.TagOutBoundMapper;
import com.kdedevelop.mediani.adapter.out.type.mapper.TypeOutBoundMapper;

public class MediaOutBoundMapper {
    public static Media toMedia(MediaMyBatisEntity mediaMyBatisEntity) {
        return new Media(
                mediaMyBatisEntity.getId(),
                TypeOutBoundMapper.toType(mediaMyBatisEntity.getType()),
                mediaMyBatisEntity.getCover(),
                mediaMyBatisEntity.getTitle(),
                LanguageOutBoundMapper.toLanguage(mediaMyBatisEntity.getLanguage()),
                mediaMyBatisEntity.getCreatedAt(),
                mediaMyBatisEntity.getUpdatedAt(),
                mediaMyBatisEntity.getCharacter().stream().map(CharacterOutBoundMapper::toCharacter).toList(),
                mediaMyBatisEntity.getCreator().stream().map(CreatorOutBoundMapper::toCreator).toList(),
                mediaMyBatisEntity.getGroup().stream().map(GroupOutBoundMapper::toGroup).toList(),
                mediaMyBatisEntity.getProducer().stream().map(ProducerOutBoundMapper::toProducer).toList(),
                mediaMyBatisEntity.getSeries().stream().map(SeriesOutBoundMapper::toSeries).toList(),
                mediaMyBatisEntity.getTag().stream().map(TagOutBoundMapper::toTag).toList()
        );
    }

    public static MediaMyBatisEntity toMediaMongoEntity(Media media) {
        return new MediaMyBatisEntity(
                media.getId(),
                TypeOutBoundMapper.toTypeMyBatisEntity(media.getType()),
                media.getCover(),
                media.getTitle(),
                LanguageOutBoundMapper.toLanguageMyBatisEntity(media.getLanguage()),
                media.getCreatedAt(),
                media.getUpdatedAt(),
                media.getCharacter().stream().map(CharacterOutBoundMapper::toCharacterMyBatisEntity).toList(),
                media.getCreator().stream().map(CreatorOutBoundMapper::toCreatorMyBatisEntity).toList(),
                media.getGroup().stream().map(GroupOutBoundMapper::toGroupMyBatisEntity).toList(),
                media.getProducer().stream().map(ProducerOutBoundMapper::toProducerMyBatisEntity).toList(),
                media.getSeries().stream().map(SeriesOutBoundMapper::toSeriesMyBatisEntity).toList(),
                media.getTag().stream().map(TagOutBoundMapper::toTagMyBatisEntity).toList()
        );
    }
}
