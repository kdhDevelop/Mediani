package com.kdedevelop.mediani.language.application.service;

import com.kdedevelop.mediani.common.EntityNotFoundException;
import com.kdedevelop.mediani.language.application.port.in.command.*;
import com.kdedevelop.mediani.language.application.port.in.usecase.*;
import com.kdedevelop.mediani.language.application.port.out.*;
import com.kdedevelop.mediani.language.domain.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageService implements LanguageCreateUseCase, LanguageReadUseCase, LanguageSearchByNameContainedUseCase, LanguageUpdateUseCase, LanguageReadOrCreateByNameUseCase {
    private final LanguageCreatePort languageCreatePort;
    private final LanguageGenerateIdPort languageGenerateIdPort;
    private final LanguageReadByIdPort languageReadByIdPort;
    private final LanguageSearchByNameContainedPort languageSearchByNameContainedPort;
    private final LanguageUpdatePort languageUpdatePort;
    private final LanguageReadByNamePort languageReadByNamePort;


    @Override
    @Transactional
    public void create(LanguageCreateCommand command) {
        Language language = new Language(languageGenerateIdPort.generateId(), command.name());
        languageCreatePort.create(language);
    }

    @Override
    @Transactional(readOnly = true)
    public Language read(LanguageReadCommand command) {
        return languageReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("language id : " + command.id() + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Language> searchLanguageByNameContained(LanguageSearchByNameContainedCommand command, Pageable pageable) {
        return languageSearchByNameContainedPort.searchLanguageByNameContained(command.name(), pageable);
    }

    @Override
    @Transactional
    public void update(LanguageUpdateCommand command) {
        Language language = languageReadByIdPort.readById(command.id()).orElseThrow(() -> new EntityNotFoundException("language id : " + command.id() + " not found"));
        language.update(command.name());
        languageUpdatePort.update(language);
    }

    @Override
    @Transactional
    public Language readOrCreateByName(LanguageReadOrCreateByNameCommand command) {
        Optional<Language> language = languageReadByNamePort.readByName(command.name());
        if (language.isEmpty()) {
            try {
                languageCreatePort.create(new Language(languageGenerateIdPort.generateId(), command.name()));
            } catch (Exception ignore) {}
            language = languageReadByNamePort.readByName(command.name());
        }
        return language.orElseThrow(() -> new IllegalStateException("language name : " + command.name() + " not found"));
    }
}
