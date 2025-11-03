package com.kdedevelop.mediani.media.adapter.out.mapper;

import com.kdedevelop.mediani.character.adapter.out.mapper.CharacterOutBoundMapper;
import com.kdedevelop.mediani.creator.adapter.out.mapper.CreatorOutBoundMapper;
import com.kdedevelop.mediani.group.adapter.out.mapper.GroupOutBoundMapper;
import com.kdedevelop.mediani.language.adapter.out.mapper.LanguageOutBoundMapper;
import com.kdedevelop.mediani.media.adapter.out.mybatis.MediaMyBatisEntity;
import com.kdedevelop.mediani.media.domain.Media;
import com.kdedevelop.mediani.producer.adapter.out.mapper.ProducerOutBoundMapper;
import com.kdedevelop.mediani.series.adapter.out.mapper.SeriesOutBoundMapper;
import com.kdedevelop.mediani.tag.adapter.out.mapper.TagOutBoundMapper;
import com.kdedevelop.mediani.type.adapter.out.mapper.TypeOutBoundMapper;

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
