package com.kdedevelop.mediani.character.application.service;

import com.kdedevelop.mediani.character.application.port.in.command.*;
import com.kdedevelop.mediani.character.application.port.in.usecase.*;
import com.kdedevelop.mediani.character.application.port.out.*;
import com.kdedevelop.mediani.character.domain.Character;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterService implements CharacterCreateUseCase, CharacterReadUseCase, CharacterUpdateUseCase, CharacterSearchByNameContainedUseCase {

    private final CharacterSearchByNameContainedPort characterSearchByNameContainedPort;
    private final CharacterGenerateIdPort characterGenerateIdPort;
    private final CharacterCreatePort characterCreatePort;
    private final CharacterReadByIdPort characterReadByIdPort;
    private final CharacterUpdatePort characterUpdatePort;

    @Override
    public void create(CharacterCreateCommand command) {
        Character character = new Character(characterGenerateIdPort.generateId(), command.name());
        characterCreatePort.create(character);
    }

    @Override
    public Character read(CharacterReadCommand command) {
        return characterReadByIdPort.read(command.id());
    }

    @Override
    public void update(CharacterUpdateCommand command) {
        Character character = new Character(command.id(), command.name());
        characterUpdatePort.update(character);
    }

    @Override
    public Page<Character> searchByNameContained(String name, Pageable pageable) {
        return characterSearchByNameContainedPort.searchByNameContained(name, pageable);
    }
}
