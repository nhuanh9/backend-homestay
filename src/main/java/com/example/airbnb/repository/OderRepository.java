package com.example.airbnb.repository;

import com.example.airbnb.model.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderRepository extends JpaRepository<OrderForm, Long> {
    Iterable<OrderForm> findAllByNameHouse(String nameHouse);

    Iterable<OrderForm> findAllByNameGuest(String nameGuest);

    Iterable<OrderForm> findAllByUserId(Long userId);


}
