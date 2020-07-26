package com.example.airbnb.service.impl;


import com.example.airbnb.model.House;
import com.example.airbnb.repository.HouseRepository;
import com.example.airbnb.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public Optional<House> findById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public void save(House house) {
        houseRepository.save(house);
    }

    @Override
    public void delete(Long id) {
        Optional<House> homeStay = houseRepository.findById(id);
        if (homeStay.isPresent()) {
            houseRepository.delete(homeStay.get());
        }
    }

    @Override
    public Iterable<House> findAllByAddress(String name) {
        return houseRepository.findAllByAddress(name);
    }

    @Override
    public Iterable<House> findAllByCategoryHouseName(String name) {
        return houseRepository.findAllByCategoryHouseName(name);
    }


}
