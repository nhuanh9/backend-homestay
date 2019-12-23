package com.example.airbnb.service.impl;


import com.example.airbnb.model.CategoryHouse;
import com.example.airbnb.repository.CategoryHouseRepository;
import com.example.airbnb.service.CategoryHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryHouseImpl implements CategoryHouseService {
    @Autowired
    private CategoryHouseRepository categoryHouseRepository;


    @Override
    public List<CategoryHouse> findAll() {
        return categoryHouseRepository.findAll();
    }

    @Override
    public Optional<CategoryHouse> findById(Long id) {
        return categoryHouseRepository.findById(id);
    }

    @Override
    public void save(CategoryHouse categoryHouse) {
categoryHouseRepository.save(categoryHouse);
    }
}
