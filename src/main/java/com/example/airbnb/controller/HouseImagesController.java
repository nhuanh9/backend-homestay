package com.example.airbnb.controller;

import com.example.airbnb.model.CategoryHouse;
import com.example.airbnb.model.House;
import com.example.airbnb.model.HouseImages;
import com.example.airbnb.service.HouseImagesService;
import com.example.airbnb.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class HouseImagesController {
    @Autowired
    private HouseImagesService houseImagesService;

    @Autowired
    private HouseService houseService;

    @GetMapping
    public ResponseEntity<Iterable<HouseImages>> getAll() {
        Iterable<HouseImages> houseImages = houseImagesService.findAll();
        return new ResponseEntity<>(houseImages, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HouseImages> create(@RequestBody HouseImages houseImages) {
        houseImagesService.save(houseImages);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional<HouseImages> houseImages = houseImagesService.findById(id);
        if (houseImages == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        houseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search-house/{house-id}")
    public ResponseEntity<Iterable<HouseImages>> getAllByHouseName(@PathVariable("house-id") Long houseId) {
        Iterable<HouseImages> houseImages = houseImagesService.findByHouseId(houseId);
        return new ResponseEntity<>(houseImages, HttpStatus.OK);

    }
}
