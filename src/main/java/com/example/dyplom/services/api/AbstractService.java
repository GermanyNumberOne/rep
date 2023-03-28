package com.example.dyplom.services.api;

import com.example.dyplom.dto.BaseDto;
import com.example.dyplom.model.BaseEntity;

import java.util.List;

public interface AbstractService<T extends BaseDto> {
    T save(T dto);
    void deleteById(Long id);
    T findById(Long id);
    List<T> getAll();
}
