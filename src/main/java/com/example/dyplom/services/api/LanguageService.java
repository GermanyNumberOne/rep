package com.example.dyplom.services.api;

import com.example.dyplom.dto.LanguageDto;

public interface LanguageService extends AbstractService<LanguageDto>{
    LanguageDto findByName(String name);
}
