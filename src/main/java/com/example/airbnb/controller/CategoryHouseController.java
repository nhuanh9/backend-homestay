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
    public ResponseEntity<Iterable<CategoryHouse>> getAll() {
        Iterable<CategoryHouse> categoryHouses = categoryHouseService.findAll();
        return new ResponseEntity<>(categoryHouses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryHouse> create(@RequestBody CategoryHouse categoryHouse) {
        categoryHouseService.save(categoryHouse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryHouse> edit(@PathVariable("id") Long id, @RequestBody CategoryHouse newCategoryHouse) {
        Optional<CategoryHouse> OldCategoryHouse = categoryHouseService.findById(id);
        if (OldCategoryHouse.isPresent()) {
            OldCategoryHouse.get().setName(newCategoryHouse.getName());

            categoryHouseService.save(OldCategoryHouse.get());
            return new ResponseEntity("thanh cong", HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
