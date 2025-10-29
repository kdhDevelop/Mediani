package com.kdedevelop.mediani.language.application.port.out;

import com.kdedevelop.mediani.language.domain.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LanguageSearchByNameContainedPort {
    Page<Language> searchLanguageByNameContained(String name, Pageable pageable);
}
