package com.kdedevelop.mediani.character.adapter.out;

import com.kdedevelop.mediani.character.adapter.out.mapper.*;
import com.kdedevelop.mediani.character.adapter.out.mongo.*;
import com.kdedevelop.mediani.character.application.port.out.*;
import com.kdedevelop.mediani.character.domain.Character;
import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.LongIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CharacterPersistenceAdapter implements CharacterCreatePort, CharacterReadByIdPort, CharacterUpdatePort, CharacterGenerateIdPort, CharacterSearchByNameContainedPort {
    private final LongIdGenerator idGenerator;
    private final CharacterMongoRepository characterMongoRepository;

    public CharacterPersistenceAdapter(@Autowired CharacterMongoRepository characterMongoRepository) {
        this.characterMongoRepository = characterMongoRepository;

        Optional<CharacterMongoEntity> entity = characterMongoRepository.findFirstByOrderByIdDesc();
        this.idGenerator = new LongIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Character character) {
        characterMongoRepository.save(CharacterOutBoundMapper.toCharacterMongoEntity(character));
    }

    @Override
    public Character read(long id) {
        CharacterMongoEntity characterMongoEntity = characterMongoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("character id " + id + " not found"));
        return CharacterOutBoundMapper.toCharacter(characterMongoEntity);
    }

    @Override
    public void update(Character character) {
        characterMongoRepository.save(CharacterOutBoundMapper.toCharacterMongoEntity(character));
    }

    @Override
    public long generateId() {
        return idGenerator.generate();
    }

    @Override
    public Page<Character> searchByNameContained(String name, Pageable pageable) {
        return characterMongoRepository.findByNameContaining(name, pageable).map(CharacterOutBoundMapper::toCharacter);
    }
}
