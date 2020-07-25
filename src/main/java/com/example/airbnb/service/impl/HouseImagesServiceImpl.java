package com.example.airbnb.service.impl;

import com.example.airbnb.model.House;
import com.example.airbnb.model.HouseImages;
import com.example.airbnb.repository.HouseImagesRepository;
import com.example.airbnb.service.HouseImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class HouseImagesServiceImpl implements HouseImagesService {

    @Autowired
    private HouseImagesRepository houseImagesRepository;

    @Override
    public Iterable<HouseImages> findAll() {
        return houseImagesRepository.findAll();
    }

    @Override
    public Optional<HouseImages> findById(Long id) {
        return houseImagesRepository.findById(id);
    }

    @Override
    public void save(HouseImages houseImages) {
        houseImagesRepository.save(houseImages);
    }

    @Override
    public void delete(Long id) {
        houseImagesRepository.deleteById(id);
    }

    @Override
    public Iterable<HouseImages> findByHouseId(Long id) {
        return houseImagesRepository.findAllByHouseId(id);
    }
}
