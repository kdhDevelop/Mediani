package com.kdedevelop.mediani.language.application.port.out;

import com.kdedevelop.mediani.language.domain.Language;

import java.util.Optional;

public interface LanguageReadByNamePort {
    Optional<Language> readByName(String name);
}
