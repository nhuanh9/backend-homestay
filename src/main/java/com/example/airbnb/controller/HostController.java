package com.example.airbnb.controller;

import com.example.airbnb.model.CategoryHouse;
import com.example.airbnb.model.CategoryRoom;
import com.example.airbnb.model.HomeStay;
import com.example.airbnb.model.Price;
import com.example.airbnb.service.CategoryHouseService;
import com.example.airbnb.service.CategoryRoomService;
import com.example.airbnb.service.HomeStayService;
import com.example.airbnb.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/host")
public class HostController {
    @Autowired
    private HomeStayService homeStayService;
    @Autowired
    private CategoryHouseService categoryHouseService;
    @Autowired
    private CategoryRoomService categoryRoomService;
    @Autowired
    private PriceService priceService;

    @GetMapping
    public ResponseEntity<List<HomeStay>> listHomeStay() {
        List<HomeStay> homeStays = homeStayService.findAll();
        if (homeStays.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homeStays, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createHomeStay(@RequestBody HomeStay homeStay) {
       CategoryHouse categoryHouse=homeStay.getCategoryHouse();
       categoryHouseService.save(categoryHouse);

        CategoryRoom categoryRoom =homeStay.getCategoryRoom();
        categoryRoomService.save(categoryRoom);

        Price price = homeStay.getPrice();
        priceService.save(price);
        homeStayService.save(homeStay);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HomeStay> editHomeStay(@RequestBody HomeStay homeStay) {
        Price price = homeStay.getPrice();
        priceService.save(price);
        homeStayService.save(homeStay);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HomeStay> detail(@PathVariable Long id) {
        Optional<HomeStay> house = homeStayService.findById(id);
        if (house.isPresent()) {
            return new ResponseEntity<HomeStay>(house.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<HomeStay>(HttpStatus.NOT_FOUND);
        }
    }

}
