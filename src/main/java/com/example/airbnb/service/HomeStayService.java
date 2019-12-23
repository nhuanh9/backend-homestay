package com.example.airbnb.service;



import com.example.airbnb.model.HomeStay;

import java.util.List;
import java.util.Optional;

public interface HomeStayService {
    List<HomeStay> findAll();

    Optional<HomeStay> findById(Long id);

    void save(HomeStay homeStay);

    void delete(HomeStay homeStay);

}
