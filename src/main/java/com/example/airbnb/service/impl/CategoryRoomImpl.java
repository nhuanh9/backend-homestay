package com.example.airbnb.service.impl;


import com.example.airbnb.model.CategoryRoom;
import com.example.airbnb.repository.CategoryRoomRepository;
import com.example.airbnb.service.CategoryRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryRoomImpl implements CategoryRoomService {
    @Autowired
    private CategoryRoomRepository categoryRoomRepository;

    @Override
    public Iterable<CategoryRoom> findAll() {
        return categoryRoomRepository.findAll();
    }

    @Override
    public Optional<CategoryRoom> findById(Long id) {
        return categoryRoomRepository.findById(id);
    }

    @Override
    public void save(CategoryRoom categoryRoom) {
        categoryRoomRepository.save(categoryRoom);
    }

    @Override
    public CategoryRoom findByNameRoom(String name) {
        return categoryRoomRepository.findByName(name);
    }


}
