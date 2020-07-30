package com.example.airbnb.repository;

import com.example.airbnb.model.OrderForm;
import com.example.airbnb.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    Iterable<Rating> findAllByHouseId(Long houseId);
}
