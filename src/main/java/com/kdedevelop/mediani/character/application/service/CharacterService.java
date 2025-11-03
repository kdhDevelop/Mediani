package com.kdedevelop.mediani.character.application.service;

import com.kdedevelop.mediani.character.application.port.in.command.*;
import com.kdedevelop.mediani.character.application.port.in.usecase.*;
import com.kdedevelop.mediani.character.application.port.out.*;
import com.kdedevelop.mediani.character.domain.Character;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CharacterService implements CharacterCreateUseCase, CharacterReadUseCase, CharacterUpdateUseCase, CharacterSearchByNameContainedUseCase, CharacterReadOrCreateByNameUseCase {

    private final CharacterSearchByNameContainedPort characterSearchByNameContainedPort;
    private final CharacterGenerateIdPort characterGenerateIdPort;
    private final CharacterCreatePort characterCreatePort;
    private final CharacterReadByIdPort characterReadByIdPort;
    private final CharacterUpdatePort characterUpdatePort;
    private final CharacterReadByNamePort characterReadByNamePort;

    @Override
    @Transactional
    public void create(CharacterCreateCommand command) {
        Character character = new Character(characterGenerateIdPort.generateId(), command.name());
        characterCreatePort.create(character);
    }

    @Override
    @Transactional(readOnly = true)
    public Character read(CharacterReadCommand command) {
        return characterReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("character id : " + command.id() + " not found"));
    }

    @Override
    @Transactional
    public void update(CharacterUpdateCommand command) {
        Character character = characterReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("character id : " + command.id() + " not found"));
        character.update(command.name());
        characterUpdatePort.update(character);
    }

    @Override
    @Transactional
    public Page<Character> searchByNameContained(String name, Pageable pageable) {
        return characterSearchByNameContainedPort.searchByNameContained(name, pageable);
    }

    @Override
    @Transactional
    public Character readOrCreateByName(CharacterReadOrCreateByNameCommand command) {
        Optional<Character> character = characterReadByNamePort.readByName(command.name());
        if (character.isEmpty()) {
            try {
                characterCreatePort.create(new Character(characterGenerateIdPort.generateId(), command.name()));
            } catch (Exception ignore) {}
            character = characterReadByNamePort.readByName(command.name());
        }
        return character.orElseThrow(() -> new IllegalStateException("character name " + command.name() + " not found"));
    }
}
