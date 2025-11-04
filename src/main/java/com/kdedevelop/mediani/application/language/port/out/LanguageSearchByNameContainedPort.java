package com.kdedevelop.mediani.application.language.port.out;

import com.kdedevelop.mediani.domain.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LanguageSearchByNameContainedPort {
    Page<Language> searchLanguageByNameContained(String name, Pageable pageable);
}
