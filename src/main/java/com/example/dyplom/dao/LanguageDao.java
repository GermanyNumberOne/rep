package com.example.dyplom.dao;

import com.example.dyplom.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language, Long> {
    Language findByName(String name);
}
