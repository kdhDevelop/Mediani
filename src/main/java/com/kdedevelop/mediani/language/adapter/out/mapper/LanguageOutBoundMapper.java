package com.kdedevelop.mediani.language.adapter.out.mapper;

import com.kdedevelop.mediani.language.adapter.out.mybatis.LanguageMyBatisEntity;
import com.kdedevelop.mediani.language.domain.Language;

public class LanguageOutBoundMapper {
    public static Language toLanguage(LanguageMyBatisEntity languageMyBatisEntity) {
        return new Language(languageMyBatisEntity.getId(), languageMyBatisEntity.getName());
    }

    public static LanguageMyBatisEntity toLanguageMyBatisEntity(Language language) {
        return new LanguageMyBatisEntity(language.getId(), language.getName());
    }
}
