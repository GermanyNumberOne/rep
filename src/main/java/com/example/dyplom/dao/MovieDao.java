package com.example.dyplom.dao;

import com.example.dyplom.model.Movie;
import com.example.dyplom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie, Long> {
}
