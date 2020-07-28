package com.example.airbnb.service.impl;

import com.example.airbnb.model.OrderForm;
import com.example.airbnb.repository.OderRepository;
import com.example.airbnb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OderRepository oderRepository;


    @Override
    public Iterable<OrderForm> findAll() {
        return oderRepository.findAll();
    }

    @Override
    public Optional<OrderForm> findById(Long id) {
        return oderRepository.findById(id);
    }

    @Override
    public void save(OrderForm orderForm) {
oderRepository.save(orderForm);
    }

    @Override
    public void delete(Long id) {
        Optional<OrderForm> oderForm = oderRepository.findById(id);
        if (oderForm.isPresent()) {
            oderRepository.delete(oderForm.get());
        }
    }

    @Override
    public Iterable<OrderForm> findAllByNameHouse(String nameHouse) {
        return oderRepository.findAllByNameHouse(nameHouse);
    }

    @Override
    public Iterable<OrderForm> findAllByNameGuest(String nameGuest) {
        return oderRepository.findAllByNameGuest(nameGuest);
    }
}
