package com.kdedevelop.mediani.language.adapter.out;

import com.kdedevelop.mediani.language.adapter.out.mapper.LanguageOutBoundMapper;
import com.kdedevelop.mediani.language.adapter.out.mybatis.LanguageMyBatisEntity;
import com.kdedevelop.mediani.infrastructure.adapter.out.generator.ShortIdGenerator;
import com.kdedevelop.mediani.language.adapter.out.mybatis.LanguageMyBatisRepository;
import com.kdedevelop.mediani.language.application.port.out.*;
import com.kdedevelop.mediani.language.domain.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LanguagePersistenceAdapterById implements LanguageCreatePort, LanguageGenerateIdPort, LanguageReadByIdPort, LanguageReadByNamePort, LanguageSearchByNameContainedPort, LanguageUpdatePort {
    private final LanguageMyBatisRepository languageMyBatisRepository;
    private final ShortIdGenerator idGenerator;

    public LanguagePersistenceAdapterById(@Autowired LanguageMyBatisRepository languageMyBatisRepository) {
        this.languageMyBatisRepository = languageMyBatisRepository;

        Optional<LanguageMyBatisEntity> entity = languageMyBatisRepository.readFirstByOrderByIdDesc();
        idGenerator = new ShortIdGenerator(entity.isPresent() ? entity.get().getId() : -1);
    }

    @Override
    public void create(Language language) {
        LanguageMyBatisEntity entity = LanguageOutBoundMapper.toLanguageMyBatisEntity(language);
        languageMyBatisRepository.create(entity);
    }

    @Override
    public short generateId() {
        return idGenerator.generate();
    }

    @Override
    public Optional<Language> readById(short id) {
        return languageMyBatisRepository.readById(id).map(LanguageOutBoundMapper::toLanguage);
    }

    @Override
    public Optional<Language> readByName(String name) {
        return languageMyBatisRepository.readByName(name).map(LanguageOutBoundMapper::toLanguage);
    }

    @Override
    public Page<Language> searchLanguageByNameContained(String name, Pageable pageable) {
        short totalElementCount = languageMyBatisRepository.countAll();
        List<LanguageMyBatisEntity> result = languageMyBatisRepository.readByNameContaining(name, pageable);
        return new PageImpl<>(result.stream().map(LanguageOutBoundMapper::toLanguage).toList(), pageable, totalElementCount);
    }

    @Override
    public void update(Language language) {
        LanguageMyBatisEntity entity = LanguageOutBoundMapper.toLanguageMyBatisEntity(language);
        languageMyBatisRepository.update(entity);
    }
}
