package com.example.airbnb.repository;

import com.example.airbnb.model.HomeStay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeStayRepository extends JpaRepository<HomeStay,Long> {
}
