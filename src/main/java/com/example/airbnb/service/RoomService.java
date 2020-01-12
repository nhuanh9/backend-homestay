package com.example.airbnb.service;

import com.example.airbnb.model.House;
import com.example.airbnb.model.Role;
import com.example.airbnb.model.Room;

import java.util.Optional;

public interface RoomService {
    Iterable<Room> findAll();
    Optional<Room> findById(Long id);
    void delete(Long id);
    void save(Room room);

}
