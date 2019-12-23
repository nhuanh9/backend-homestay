package com.example.airbnb.repository;


import com.example.airbnb.model.CategoryHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryHomeRepository extends JpaRepository<CategoryHouse,Long> {
    CategoryHouse findByName(String name);
}
