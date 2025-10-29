package com.kdedevelop.mediani.language.application.port.in.usecase;

import com.kdedevelop.mediani.language.application.port.in.command.LanguageSearchByNameContainedCommand;
import com.kdedevelop.mediani.language.domain.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LanguageSearchByNameContainedUseCase {
    Page<Language> searchLanguageByNameContained(LanguageSearchByNameContainedCommand command, Pageable pageable);
}
