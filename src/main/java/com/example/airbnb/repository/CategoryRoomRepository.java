package com.example.airbnb.repository;


import com.example.airbnb.model.CategoryRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRoomRepository extends JpaRepository<CategoryRoom,Long> {
    Optional<CategoryRoom> findByName(String name);
}
