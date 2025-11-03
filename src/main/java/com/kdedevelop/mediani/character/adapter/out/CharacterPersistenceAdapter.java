package com.kdedevelop.mediani.character.adapter.out;

import com.kdedevelop.mediani.character.adapter.out.mapper.*;
import com.kdedevelop.mediani.character.adapter.out.mybatis.*;
import com.kdedevelop.mediani.character.application.port.out.*;
import com.kdedevelop.mediani.character.domain.Character;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.LongIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CharacterPersistenceAdapter implements CharacterCreatePort, CharacterReadByIdPort, CharacterUpdatePort, CharacterGenerateIdPort, CharacterSearchByNameContainedPort, CharacterReadByNamePort {
    private final LongIdGenerator idGenerator;
    private final CharacterMyBatisRepository characterMyBatisRepository;

    public CharacterPersistenceAdapter(@Autowired CharacterMyBatisRepository characterMyBatisRepository) {
        this.characterMyBatisRepository = characterMyBatisRepository;

        Optional<CharacterMyBatisEntity> entity = characterMyBatisRepository.readFirstByOrderByIdDesc();
        this.idGenerator = new LongIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Character character) {
        characterMyBatisRepository.create(CharacterOutBoundMapper.toCharacterMyBatisEntity(character));
    }

    @Override
    public Optional<Character> readById(long id) {
        return characterMyBatisRepository.readById(id).map(CharacterOutBoundMapper::toCharacter);
    }

    @Override
    public Optional<Character> readByName(String name) {
        return characterMyBatisRepository.readByName(name).map(CharacterOutBoundMapper::toCharacter);
    }

    @Override
    public void update(Character character) {
        characterMyBatisRepository.update(CharacterOutBoundMapper.toCharacterMyBatisEntity(character));
    }

    @Override
    public long generateId() {
        return idGenerator.generate();
    }

    @Override
    public Page<Character> searchByNameContained(String name, Pageable pageable) {
        long totalElement = characterMyBatisRepository.countAll();
        List<CharacterMyBatisEntity> result = characterMyBatisRepository.readByNameContaining(name, pageable);
        return new PageImpl<>(result.stream().map(CharacterOutBoundMapper::toCharacter).toList(), pageable, totalElement);
    }
}
