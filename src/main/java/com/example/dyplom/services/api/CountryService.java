package com.example.dyplom.services.api;

import com.example.dyplom.dto.CountryDto;

public interface CountryService extends AbstractService<CountryDto>{
    CountryDto findByName(String name);
}
