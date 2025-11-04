package com.kdedevelop.mediani.adapter.out.media;

import com.kdedevelop.mediani.application.media.port.out.*;
import com.kdedevelop.mediani.domain.Character;
import com.kdedevelop.mediani.domain.Creator;
import com.kdedevelop.mediani.domain.Group;
import com.kdedevelop.mediani.adapter.out.media.mapper.MediaOutBoundMapper;
import com.kdedevelop.mediani.adapter.out.media.mybatis.MediaMyBatisEntity;
import com.kdedevelop.mediani.adapter.out.media.mybatis.MediaMyBatisRepository;
import com.kdedevelop.mediani.adapter.out.media.mybatis.relationship.*;
import com.kdedevelop.mediani.domain.Media;
import com.kdedevelop.mediani.domain.Producer;
import com.kdedevelop.mediani.domain.Series;
import com.kdedevelop.mediani.domain.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MediaPersistenceAdapter implements MediaCreatePort, MediaUpdatePort, MediaUpdateCharacterPort, MediaUpdateCreatorPort, MediaUpdateGroupPort, MediaUpdateProducerPort, MediaUpdateSeriesPort, MediaUpdateTagPort, MediaDeletePort, MediaReadByIdPort {
    private final MediaMyBatisRepository mediaMyBatisRepository;
    private final MediaCharacterMyBatisRelationshipRepository mediaCharacterMyBatisRelationshipRepository;
    private final MediaCreatorMyBatisRelationshipRepository mediaCreatorMyBatisRelationshipRepository;
    private final MediaGroupMyBatisRelationshipRepository mediaGroupMyBatisRelationshipRepository;
    private final MediaProducerMyBatisRelationshipRepository mediaProducerMyBatisRelationshipRepository;
    private final MediaSeriesMyBatisRelationshipRepository mediaSeriesMyBatisRelationshipRepository;
    private final MediaTagMyBatisRelationshipRepository mediaTagMyBatisRelationshipRepository;

    @Override
    public void create(Media media) {
        MediaMyBatisEntity entity = MediaOutBoundMapper.toMediaMongoEntity(media);
        mediaMyBatisRepository.create(entity);
        mediaCharacterMyBatisRelationshipRepository.createAll(entity.getCharacter().stream().map((character) -> new MediaCharacterMyBatisRelationshipRepository.Key(entity.getType().getId(), entity.getId(), character.getId())).toList());
        mediaCreatorMyBatisRelationshipRepository.createAll(entity.getCreator().stream().map((creator) -> new MediaCreatorMyBatisRelationshipRepository.Key(entity.getType().getId(), entity.getId(), creator.getId())).toList());
        mediaGroupMyBatisRelationshipRepository.createAll(entity.getGroup().stream().map((group) -> new MediaGroupMyBatisRelationshipRepository.Key(entity.getType().getId(), entity.getId(), group.getId())).toList());
        mediaProducerMyBatisRelationshipRepository.createAll(entity.getProducer().stream().map((producer) -> new MediaProducerMyBatisRelationshipRepository.Key(entity.getType().getId(), entity.getId(), producer.getId())).toList());
        mediaSeriesMyBatisRelationshipRepository.createAll(entity.getSeries().stream().map((series) -> new MediaSeriesMyBatisRelationshipRepository.Key(entity.getType().getId(), entity.getId(), series.getId())).toList());
        mediaTagMyBatisRelationshipRepository.createAll(entity.getTag().stream().map((tag) -> new MediaTagMyBatisRelationshipRepository.Key(entity.getType().getId(), entity.getId(), tag.getId())).toList());
    }

    @Override
    public void update(Media media) {
        mediaMyBatisRepository.update(MediaOutBoundMapper.toMediaMongoEntity(media));
    }

    @Override
    public void addCharacter(Media media, Character character) {
        mediaCharacterMyBatisRelationshipRepository.create(new MediaCharacterMyBatisRelationshipRepository.Key(media.getType().getId(), media.getId(), character.getId()));
    }

    @Override
    public void deleteCharacter(Media media, Character character) {
        mediaCharacterMyBatisRelationshipRepository.delete(new MediaCharacterMyBatisRelationshipRepository.Key(media.getType().getId(), media.getId(), character.getId()));
    }

    @Override
    public void addCreator(Media media, Creator creator) {
        mediaCreatorMyBatisRelationshipRepository.create(new MediaCreatorMyBatisRelationshipRepository.Key(media.getType().getId(), media.getId(), creator.getId()));
    }

    @Override
    public void deleteCreator(Media media, Creator creator) {
        mediaCreatorMyBatisRelationshipRepository.create(new MediaCreatorMyBatisRelationshipRepository.Key(media.getType().getId(), media.getId(), creator.getId()));
    }

    @Override
    public void addGroup(Media media, Group group) {
        mediaGroupMyBatisRelationshipRepository.create(new MediaGroupMyBatisRelationshipRepository.Key(media.getType().getId(), media.getId(), group.getId()));
    }

    @Override
    public void deleteGroup(Media media, Group group) {
        mediaGroupMyBatisRelationshipRepository.delete(new MediaGroupMyBatisRelationshipRepository.Key(media.getType().getId(), media.getId(), group.getId()));
    }

    @Override
    public void addProducer(Media media, Producer producer) {
        mediaProducerMyBatisRelationshipRepository.create(new MediaProducerMyBatisRelationshipRepository.Key(media.getType().getId(), media.getId(), producer.getId()));
    }

    @Override
    public void deleteProducer(Media media, Producer producer) {
        mediaProducerMyBatisRelationshipRepository.delete(new MediaProducerMyBatisRelationshipRepository.Key(media.getType().getId(), media.getId(), producer.getId()));
    }

    @Override
    public void addSeries(Media media, Series series) {
        mediaSeriesMyBatisRelationshipRepository.create(new MediaSeriesMyBatisRelationshipRepository.Key(media.getType().getId(), media.getId(), series.getId()));
    }

    @Override
    public void deleteSeries(Media media, Series series) {
        mediaSeriesMyBatisRelationshipRepository.delete(new MediaSeriesMyBatisRelationshipRepository.Key(media.getType().getId(), media.getId(), series.getId()));
    }

    @Override
    public void addTag(Media media, Tag tag) {
        mediaTagMyBatisRelationshipRepository.create(new MediaTagMyBatisRelationshipRepository.Key(media.getType().getId(), media.getId(), tag.getId()));
    }

    @Override
    public void deleteTag(Media media, Tag tag) {
        mediaTagMyBatisRelationshipRepository.delete(new MediaTagMyBatisRelationshipRepository.Key(media.getType().getId(), media.getId(), tag.getId()));
    }

    @Override
    public void delete(short typeId, long mediaId) {
        mediaMyBatisRepository.delete(typeId, mediaId);
    }

    @Override
    public Optional<Media> readById(short typeId, long mediaId) {
        return mediaMyBatisRepository.read(typeId, mediaId).map(MediaOutBoundMapper::toMedia);
    }
}
