package com.example.airbnb.controller;


import com.example.airbnb.model.HomeStay;

import com.example.airbnb.service.HomeStayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/host")
public class HostController {
    @Autowired
    private HomeStayService homeStayService;


    @GetMapping
    public ResponseEntity<List<HomeStay>> listHomeStay() {
        List<HomeStay> homeStays = homeStayService.findAll();
        if (homeStays.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homeStays, HttpStatus.OK);
    }



}
