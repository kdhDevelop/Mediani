package com.kdedevelop.mediani.adapter.out.language.mapper;

import com.kdedevelop.mediani.adapter.out.language.mybatis.LanguageMyBatisEntity;
import com.kdedevelop.mediani.domain.Language;

public class LanguageOutBoundMapper {
    public static Language toLanguage(LanguageMyBatisEntity languageMyBatisEntity) {
        return new Language(languageMyBatisEntity.getId(), languageMyBatisEntity.getName());
    }

    public static LanguageMyBatisEntity toLanguageMyBatisEntity(Language language) {
        return new LanguageMyBatisEntity(language.getId(), language.getName());
    }
}
