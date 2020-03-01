package com.example.airbnb.service;

import com.example.airbnb.model.OrderForm;

import java.util.Optional;

public interface OrderService {
    Iterable<OrderForm>findAll();
    Optional<OrderForm>findById(Long id);
    void save(OrderForm orderForm);
    void delete(Long id);
}
