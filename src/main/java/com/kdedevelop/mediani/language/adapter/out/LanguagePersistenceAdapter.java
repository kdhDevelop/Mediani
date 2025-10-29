package com.kdedevelop.mediani.language.adapter.out;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.ShortIdGenerator;
import com.kdedevelop.mediani.language.adapter.out.mapper.LanguageOutBoundMapper;
import com.kdedevelop.mediani.language.adapter.out.mongo.LanguageMongoEntity;
import com.kdedevelop.mediani.language.adapter.out.mongo.LanguageMongoRepository;
import com.kdedevelop.mediani.language.application.port.out.*;
import com.kdedevelop.mediani.language.domain.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LanguagePersistenceAdapter implements LanguageCreatePort, LanguageGenerateIdPort, LanguageReadPort, LanguageSearchByNameContainedPort, LanguageUpdatePort {
    private final LanguageMongoRepository languageMongoRepository;
    private final ShortIdGenerator idGenerator;

    public LanguagePersistenceAdapter(@Autowired LanguageMongoRepository languageMongoRepository) {
        this.languageMongoRepository = languageMongoRepository;

        Optional<LanguageMongoEntity> entity = languageMongoRepository.findFirstByOrderByIdDesc();
        idGenerator = new ShortIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Language language) {
        LanguageMongoEntity entity = LanguageOutBoundMapper.toLanguageMongoEntity(language);
        languageMongoRepository.save(entity);
    }

    @Override
    public short generateId() {
        return idGenerator.generate();
    }

    @Override
    public Language read(short id) {
        return LanguageOutBoundMapper.toLanguage(languageMongoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("language id : " + id + " not found")));
    }

    @Override
    public Page<Language> searchLanguageByNameContained(String name, Pageable pageable) {
        return languageMongoRepository.findByNameContaining(name, pageable).map(LanguageOutBoundMapper::toLanguage);
    }

    @Override
    public void update(Language language) {
        LanguageMongoEntity entity = LanguageOutBoundMapper.toLanguageMongoEntity(language);
        languageMongoRepository.save(entity);
    }
}
