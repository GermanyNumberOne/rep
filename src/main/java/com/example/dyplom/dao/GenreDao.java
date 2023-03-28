package com.example.dyplom.dao;

import com.example.dyplom.model.Genre;
import com.example.dyplom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<Genre, Long> {
}
