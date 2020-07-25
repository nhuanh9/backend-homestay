package com.example.airbnb.repository;

import com.example.airbnb.model.House;
import com.example.airbnb.model.HouseImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseImagesRepository extends JpaRepository<HouseImages,Long> {
    Iterable<HouseImages>findAllByHouseId(Long id);
}
