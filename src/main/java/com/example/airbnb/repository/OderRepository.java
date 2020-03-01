package com.example.airbnb.repository;

import com.example.airbnb.model.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderRepository extends JpaRepository<OrderForm,Long> {
}
