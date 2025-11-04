package com.kdedevelop.mediani.application.language.port.out;

import com.kdedevelop.mediani.domain.Language;

import java.util.Optional;

public interface LanguageReadByNamePort {
    Optional<Language> readByName(String name);
}
