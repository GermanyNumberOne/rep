package com.example.dyplom.dao;

import com.example.dyplom.model.MovieList;
import com.example.dyplom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieListDao extends JpaRepository<MovieList, Long> {
}
