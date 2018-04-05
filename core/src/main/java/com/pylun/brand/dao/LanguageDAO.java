package com.pylun.brand.dao;

import com.pylun.brand.model.Language;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface LanguageDAO
{
    Language getLanguage(long languageIdx);

    int insertLanguage(Language language);

//    int updateLanguage(Language language);
}
