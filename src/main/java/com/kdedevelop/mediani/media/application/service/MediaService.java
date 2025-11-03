package com.kdedevelop.mediani.media.application.service;

import com.kdedevelop.mediani.character.application.port.in.command.CharacterReadOrCreateByNameCommand;
import com.kdedevelop.mediani.character.application.port.in.usecase.CharacterReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.character.domain.Character;
import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.creator.application.port.in.command.CreatorReadOrCreateByNameCommand;
import com.kdedevelop.mediani.creator.application.port.in.usecase.CreatorReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.creator.domain.Creator;
import com.kdedevelop.mediani.group.application.port.in.command.GroupReadOrCreateByNameCommand;
import com.kdedevelop.mediani.group.application.port.in.usecase.GroupReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.group.domain.Group;
import com.kdedevelop.mediani.language.application.port.in.command.LanguageReadOrCreateByNameCommand;
import com.kdedevelop.mediani.language.application.port.in.usecase.LanguageReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.language.domain.Language;
import com.kdedevelop.mediani.media.application.port.in.command.MediaCreateCommand;
import com.kdedevelop.mediani.media.application.port.in.command.MediaReadByIdCommand;
import com.kdedevelop.mediani.media.application.port.in.usecase.MediaCreateUseCase;
import com.kdedevelop.mediani.media.application.port.in.usecase.MediaReadByIdUseCase;
import com.kdedevelop.mediani.media.application.port.out.MediaCreatePort;
import com.kdedevelop.mediani.media.application.port.out.MediaReadByIdPort;
import com.kdedevelop.mediani.media.domain.Media;
import com.kdedevelop.mediani.producer.application.port.in.command.ProducerReadOrCreateByNameCommand;
import com.kdedevelop.mediani.producer.application.port.in.usecase.ProducerReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.producer.domain.Producer;
import com.kdedevelop.mediani.series.application.port.in.command.SeriesReadOrCreateByNameCommand;
import com.kdedevelop.mediani.series.application.port.in.usecase.SeriesReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.series.domain.Series;
import com.kdedevelop.mediani.tag.application.port.in.command.TagReadOrCreateByNameCommand;
import com.kdedevelop.mediani.tag.application.port.in.usecase.TagReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.tag.domain.Tag;
import com.kdedevelop.mediani.type.application.port.in.command.TypeReadOrCreateByNameCommand;
import com.kdedevelop.mediani.type.application.port.in.usecase.TypeReadOrCreateByNameUseCase;
import com.kdedevelop.mediani.type.domain.Type;
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
