package com.example.airbnb.service.impl;


import com.example.airbnb.model.Price;
import com.example.airbnb.repository.PriceRepository;
import com.example.airbnb.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<Price> findAll() {
        return priceRepository.findAll();
    }

    @Override
    public Optional<Price> findById(Long id) {
        return priceRepository.findById(id);
    }

    @Override
    public void save(Price price) {
        priceRepository.save(price);
    }

}