package com.example.dyplom.dao;

import com.example.dyplom.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country, Long> {
    Country findByName(String name);
}
