package com.kdedevelop.mediani.application.media.service;

import com.kdedevelop.mediani.common.EntityNotFoundException;

import com.kdedevelop.mediani.application.character.port.in.command.CharacterReadOrCreateByNameCommand;
import com.kdedevelop.mediani.application.character.port.in.usecase.CharacterReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.domain.Character;

import com.kdedevelop.mediani.application.creator.port.in.command.CreatorReadOrCreateByNameCommand;
import com.kdedevelop.mediani.application.creator.port.in.usecase.CreatorReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.domain.Creator;

import com.kdedevelop.mediani.application.group.port.in.command.GroupReadOrCreateByNameCommand;
import com.kdedevelop.mediani.application.group.port.in.usecase.GroupReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.domain.Group;

import com.kdedevelop.mediani.application.language.port.in.command.LanguageReadOrCreateByNameCommand;
import com.kdedevelop.mediani.application.language.port.in.usecase.LanguageReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.domain.Language;

import com.kdedevelop.mediani.application.media.port.in.command.MediaCreateCommand;
import com.kdedevelop.mediani.application.media.port.in.command.MediaReadByIdCommand;
import com.kdedevelop.mediani.application.media.port.in.usecase.MediaCreateUseCase;
import com.kdedevelop.mediani.application.media.port.in.usecase.MediaReadByIdUseCase;
import com.kdedevelop.mediani.application.media.port.out.MediaCreatePort;
import com.kdedevelop.mediani.application.media.port.out.MediaReadByIdPort;
import com.kdedevelop.mediani.domain.Media;

import com.kdedevelop.mediani.application.producer.port.in.command.ProducerReadOrCreateByNameCommand;
import com.kdedevelop.mediani.application.producer.port.in.usecase.ProducerReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.domain.Producer;

import com.kdedevelop.mediani.application.series.port.in.command.SeriesReadOrCreateByNameCommand;
import com.kdedevelop.mediani.application.series.port.in.usecase.SeriesReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.domain.Series;

import com.kdedevelop.mediani.application.tag.port.in.command.TagReadOrCreateByNameCommand;
import com.kdedevelop.mediani.application.tag.port.in.usecase.TagReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.domain.Tag;

import com.kdedevelop.mediani.application.type.port.in.command.TypeReadOrCreateByNameCommand;
import com.kdedevelop.mediani.application.type.port.in.usecase.TypeReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.domain.Type;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaService implements MediaCreateUseCase, MediaReadByIdUseCase {
    private final MediaCreatePort mediaCreatePort;
    private final MediaReadByIdPort mediaReadByIdPort;

    private final TypeReadOrCreateByNameUseCase typeReadOrCreateByNameUseCase;
    private final LanguageReadOrCreateByNameUseCase languageReadOrCreateByNameUseCase;
    private final CharacterReadOrCreateByNameUseCase characterReadOrCreateByNameUseCase;
    private final CreatorReadOrCreateByNameUseCase creatorReadOrCreateByNameUseCase;
    private final GroupReadOrCreateByNameUseCase groupReadOrCreateByNameUseCase;
    private final ProducerReadOrCreateByNameUseCase producerReadOrCreateByNameUseCase;
    private final SeriesReadOrCreateByNameUseCase seriesReadOrCreateByNameUseCase;
    private final TagReadOrCreateByNameUseCase tagReadOrCreateByNameUseCase;

    @Override
    @Transactional
    public void create(MediaCreateCommand command) {
        System.out.println(command);

        Type type = typeReadOrCreateByNameUseCase.readOrCreateByName(new TypeReadOrCreateByNameCommand(command.type()));
        Language language = languageReadOrCreateByNameUseCase.readOrCreateByName(new LanguageReadOrCreateByNameCommand(command.language()));
        List<Character> character = command.characterList().stream().map(CharacterReadOrCreateByNameCommand::new).map(characterReadOrCreateByNameUseCase::readOrCreateByName).toList();
        List<Creator> creator = command.creatorList().stream().map(CreatorReadOrCreateByNameCommand::new).map(creatorReadOrCreateByNameUseCase::readOrCreateByName).toList();
        List<Group> group = command.groupList().stream().map(GroupReadOrCreateByNameCommand::new).map(groupReadOrCreateByNameUseCase::readOrCreateByName).toList();
        List<Producer> producer = command.producerList().stream().map(ProducerReadOrCreateByNameCommand::new).map(producerReadOrCreateByNameUseCase::readOrCreateByName).toList();
        List<Series> series = command.seriesList().stream().map(SeriesReadOrCreateByNameCommand::new).map(seriesReadOrCreateByNameUseCase::readOrCreateByName).toList();
        List<Tag> tag = command.tagList().stream().map(TagReadOrCreateByNameCommand::new).map(tagReadOrCreateByNameUseCase::readOrCreateByName).toList();

        Media media = new Media(
                command.id(),
                type,
                command.cover(),
                command.title(),
                command.description(),
                language,
                LocalDateTime.now(),
                LocalDateTime.now(),
                character,
                creator,
                group,
                producer,
                series,
                tag
        );

        mediaCreatePort.create(media);
    }

    @Override
    @Transactional(readOnly = true)
    public Media readById(MediaReadByIdCommand command) {
        return mediaReadByIdPort.readById(command.typeId(), command.mediaId()).orElseThrow(() -> new EntityNotFoundException("type id : " + command.typeId() + " media id : " + command.mediaId() + " not found"));
    }
}
