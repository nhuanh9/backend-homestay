package com.example.airbnb.service.impl;

import com.example.airbnb.model.OrderForm;
import com.example.airbnb.repository.OrderRepository;
import com.example.airbnb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Iterable<OrderForm> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<OrderForm> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(OrderForm orderForm) {
orderRepository.save(orderForm);
    }

    @Override
    public void delete(Long id) {
        Optional<OrderForm> oderForm = orderRepository.findById(id);
        if (oderForm.isPresent()) {
            orderRepository.delete(oderForm.get());
        }
    }

    @Override
    public Iterable<OrderForm> findAllByNameHouse(String nameHouse) {
        return orderRepository.findAllByNameHouse(nameHouse);
    }

    @Override
    public Iterable<OrderForm> findAllByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public Iterable<OrderForm> findAllByNameGuest(String nameGuest) {
        return orderRepository.findAllByNameGuest(nameGuest);
    }
}
