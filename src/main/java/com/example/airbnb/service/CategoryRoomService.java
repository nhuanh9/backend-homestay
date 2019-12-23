package com.example.airbnb.service;


import com.example.airbnb.model.CategoryRoom;

import java.util.Optional;

public interface CategoryRoomService {
    Iterable<CategoryRoom> findAll();

    Optional<CategoryRoom> findById(Long id);

    void save(CategoryRoom categoryRoom);
    CategoryRoom findByNameRoom(String name);
}
