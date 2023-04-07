package com.example.dyplom.services.api;

import com.example.dyplom.dto.GenreDto;

import java.util.List;

public interface GenreService extends AbstractService<GenreDto>{
    List<GenreDto> saveAll(List<GenreDto> genreDtos);
}
