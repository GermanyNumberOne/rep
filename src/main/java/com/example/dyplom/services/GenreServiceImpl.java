package com.example.dyplom.services;

import com.example.dyplom.dao.GenreDao;
import com.example.dyplom.dto.GenreDto;
import com.example.dyplom.model.Genre;
import com.example.dyplom.services.api.GenreService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreDao genreDao;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public GenreDto save(GenreDto dto) {
        return null;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        genreDao.deleteById(id);
    }

    @Transactional
    @Override
    public List<GenreDto> saveAll(List<GenreDto> genreDtos){
        List<Genre> genres = genreDao.saveAll(genreDtos.stream().map(genreDto -> modelMapper.map(genreDto, Genre.class)).collect(Collectors.toList()));
        return genres.stream().map(genre -> modelMapper.map(genre, GenreDto.class)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public GenreDto findById(Long id) {
        return null;
    }

    @Transactional
    @Override
    public List<GenreDto> getAll() {
        return null;
    }
}
