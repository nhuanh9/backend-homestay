package com.example.airbnb.controller;


import com.example.airbnb.model.CategoryHouse;
import com.example.airbnb.service.CategoryHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")

@RequestMapping("/category/house")
public class CategoryHouseController {
    @Autowired
    private CategoryHouseService categoryHouseService;

    @GetMapping
    public ResponseEntity<Iterable<CategoryHouse>> listCategoryHome() {
        Iterable<CategoryHouse> categoryHomes = categoryHouseService.findAll();
        return new ResponseEntity<>(categoryHomes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryHouse> createCategoryHome(@RequestBody CategoryHouse categoryHouse) {
        categoryHouseService.save(categoryHouse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryHouse> editCategoryRoom(@PathVariable("id") Long id, @RequestBody CategoryHouse categoryHouse) {
        Optional<CategoryHouse> categoryHome1 = categoryHouseService.findById(id);
        if (categoryHome1.isPresent()) {
            categoryHome1.get().setName(categoryHouse.getName());

            categoryHouseService.save(categoryHome1.get());
            return new ResponseEntity("thanh cong", HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
