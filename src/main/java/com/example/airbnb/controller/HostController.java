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
    public ResponseEntity<Iterable<HomeStay>>listHouse(){
        Iterable<HomeStay>homeStays=homeStayService.findAll();
        return new ResponseEntity<>(homeStays, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<HomeStay>createHouse(@RequestBody HomeStay homeStay){
        if (homeStay.getCategoryRoom()!=null){
        String name=homeStay.getCategoryRoom().getName();
        categoryRoomService.findByNameRoom(name);
        }
        if (homeStay.getCategoryHouse() != null){
            String nameHouse=homeStay.getCategoryHouse().getName();
            categoryHouseService.findByName(nameHouse);
        }
        if (homeStay.getPrice()!=null){
            Price price=homeStay.getPrice();
            priceService.save(price);
        }
        homeStayService.save(homeStay);



        return new ResponseEntity<>(HttpStatus.CREATED);


}}