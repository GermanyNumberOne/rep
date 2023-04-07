package com.example.dyplom.services;

import com.example.dyplom.dao.CountryDao;
import com.example.dyplom.dao.RoleDao;
import com.example.dyplom.dto.CountryDto;
import com.example.dyplom.dto.RoleDto;
import com.example.dyplom.model.Country;
import com.example.dyplom.model.Role;
import com.example.dyplom.services.api.CountryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private ModelMapper modelMapper;
    private CountryDao countryDao;

    @Transactional
    @Override
    public CountryDto save(CountryDto dto) {
        Country country = countryDao.save(modelMapper.map(dto, Country.class));
        return modelMapper.map(country, CountryDto.class);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        countryDao.deleteById(id);
    }

    @Transactional
    @Override
    public CountryDto findById(Long id) {
        return modelMapper.map(countryDao.findById(id), CountryDto.class);
    }

    @Transactional
    @Override
    public List<CountryDto> getAll() {
        return countryDao.findAll().stream().map(role -> modelMapper.map(role, CountryDto.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public CountryDto findByName(String name) {
        return modelMapper.map(countryDao.findByName(name), CountryDto.class);
    }

}
