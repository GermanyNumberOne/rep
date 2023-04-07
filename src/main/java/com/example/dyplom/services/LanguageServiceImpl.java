package com.example.dyplom.services;

import com.example.dyplom.dao.LanguageDao;
import com.example.dyplom.dto.CountryDto;
import com.example.dyplom.dto.LanguageDto;
import com.example.dyplom.model.Country;
import com.example.dyplom.model.Language;
import com.example.dyplom.services.api.LanguageService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private LanguageDao languageDao;
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public LanguageDto save(LanguageDto dto) {
        Language language = languageDao.save(modelMapper.map(dto, Language.class));
        return modelMapper.map(language, LanguageDto.class);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        languageDao.deleteById(id);
    }

    @Transactional
    @Override
    public LanguageDto findById(Long id) {
        return modelMapper.map(languageDao.findById(id), LanguageDto.class);
    }

    @Transactional
    @Override
    public List<LanguageDto> getAll() {
        return languageDao.findAll().stream().map(role -> modelMapper.map(role, LanguageDto.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public LanguageDto findByName(String name) {
        return modelMapper.map(languageDao.findByName(name), LanguageDto.class);
    }

}
