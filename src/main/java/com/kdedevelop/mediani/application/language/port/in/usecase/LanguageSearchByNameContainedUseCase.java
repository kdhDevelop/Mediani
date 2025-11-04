package com.kdedevelop.mediani.application.language.port.in.usecase;

import com.kdedevelop.mediani.application.language.port.in.command.LanguageSearchByNameContainedCommand;
import com.kdedevelop.mediani.domain.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LanguageSearchByNameContainedUseCase {
    Page<Language> searchLanguageByNameContained(LanguageSearchByNameContainedCommand command, Pageable pageable);
}
