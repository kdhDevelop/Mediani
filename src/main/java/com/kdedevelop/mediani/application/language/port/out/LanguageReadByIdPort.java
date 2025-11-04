package com.kdedevelop.mediani.application.language.port.out;

import com.kdedevelop.mediani.domain.Language;

import java.util.Optional;

public interface LanguageReadByIdPort {
    Optional<Language> readById(short id);
}
