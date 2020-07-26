package com.example.airbnb.repository;

import com.example.airbnb.model.HouseImages;
import com.example.airbnb.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Iterable<Room> findAllByNameHouse(String nameHouse);
}
