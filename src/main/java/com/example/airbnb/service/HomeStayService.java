package com.example.airbnb.service;


import com.example.airbnb.model.HomeStay;

import java.util.List;
import java.util.Optional;

public interface HomeStayService {
    Iterable<HomeStay> findAll();

    Optional<HomeStay> findById(Long id);

    void save(HomeStay homeStay);

    void delete(Long id);

}
