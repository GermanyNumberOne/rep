package com.example.dyplom.controllers;

import com.example.dyplom.dto.GenreDto;
import com.example.dyplom.services.api.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@AllArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping(name = "/save-all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GenreDto> saveAll(@RequestBody List<GenreDto> genreDtos){
        return genreService.saveAll(genreDtos);
    }

    @GetMapping(name = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GenreDto> getAll(){
        return genreService.getAll();
    }
}
