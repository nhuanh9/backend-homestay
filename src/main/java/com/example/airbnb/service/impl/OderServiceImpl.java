package com.example.airbnb.service.impl;

import com.example.airbnb.model.House;
import com.example.airbnb.model.OderForm;
import com.example.airbnb.repository.OderRepository;
import com.example.airbnb.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OderServiceImpl implements OderService {
    @Autowired
    private OderRepository oderRepository;


    @Override
    public Iterable<OderForm> findAll() {
        return oderRepository.findAll();
    }

    @Override
    public Optional<OderForm> findById(Long id) {
        return oderRepository.findById(id);
    }

    @Override
    public void save(OderForm oderForm) {
oderRepository.save(oderForm);
    }

    @Override
    public void delete(Long id) {
        Optional<OderForm> oderForm = oderRepository.findById(id);
        if (oderForm.isPresent()) {
            oderRepository.delete(oderForm.get());
        }
    }
}
