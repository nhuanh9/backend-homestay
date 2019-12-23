package com.example.airbnb.service;


import com.example.airbnb.model.CategoryRoom;

import java.util.List;
import java.util.Optional;

public interface CategoryRoomService {
    List<CategoryRoom> findAll();

    Optional<CategoryRoom> findById(Long id);

    void save(CategoryRoom categoryRoom);

}
