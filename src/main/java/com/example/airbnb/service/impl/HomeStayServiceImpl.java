package com.example.airbnb.service.impl;


import com.example.airbnb.model.HomeStay;
import com.example.airbnb.repository.HomeStayRepository;
import com.example.airbnb.service.HomeStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeStayServiceImpl implements HomeStayService {

    @Autowired
    private HomeStayRepository homeStayRepository;

    @Override
    public List<HomeStay> findAll() {
        return homeStayRepository.findAll();
    }

    @Override
    public Optional<HomeStay> findById(Long id) {
        return homeStayRepository.findById(id);
    }

    @Override
    public void save(HomeStay homeStay) {
    homeStayRepository.save(homeStay);
    }

    @Override
    public void delete(Long id) {
        Optional<HomeStay> homeStay = homeStayRepository.findById(id);
        if (homeStay.isPresent()) {
            homeStayRepository.delete(homeStay.get());
        }
    }


}
