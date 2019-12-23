package com.example.airbnb.service.impl;


import com.example.airbnb.model.CategoryHouse;
import com.example.airbnb.repository.CategoryHomeRepository;
import com.example.airbnb.service.CategoryHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryHouseImpl implements CategoryHouseService {
    @Autowired
    private CategoryHomeRepository categoryHomeRepository;

    @Override
    public Iterable<CategoryHouse> findAll() {
        return categoryHomeRepository.findAll();
    }

    @Override
    public Optional<CategoryHouse> findById(Long id) {
        return categoryHomeRepository.findById(id);
    }

    @Override
    public void save(CategoryHouse categoryHome) {
        categoryHomeRepository.save(categoryHome);
    }

    @Override
    public Optional<CategoryHouse> findByName(String name) {
        return categoryHomeRepository.findByName(name);
    }

}
