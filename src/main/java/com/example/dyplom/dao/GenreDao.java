package com.example.dyplom.dao;

import com.example.dyplom.model.Genre;
import com.example.dyplom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreDao extends JpaRepository<Genre, Long> {

}
