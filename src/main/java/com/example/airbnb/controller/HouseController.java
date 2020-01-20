package com.example.airbnb.controller;

import com.example.airbnb.model.*;

import com.example.airbnb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping()
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private CategoryHouseService categoryHouseService;
    @Autowired
    private CategoryRoomService categoryRoomService;

    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;

    //danh sach tat ca cac nha
    @GetMapping("/house")
    public ResponseEntity<Iterable<House>> listHouse() {
        Iterable<House> homeStays = houseService.findAll();
        return new ResponseEntity<>(homeStays, HttpStatus.OK);
    }

    //sua thong tin 1 nha
    @PutMapping("/house/{id}")
    public ResponseEntity<House> edit(@PathVariable("id") Long id, @RequestBody House house) {
        Optional<House> homeStay1 = houseService.findById(id);
        if (homeStay1.isPresent()) {
            if (!house.getNameHouse().equals("")) {
                homeStay1.get().setNameHouse(house.getNameHouse());
            }
            if (house.getCategoryHouse().getId()!=null) {
                String nameHouse = house.getCategoryHouse().getName();
                CategoryHouse categoryHouse = categoryHouseService.findByName(nameHouse);
                homeStay1.get().setCategoryHouse(categoryHouse);
            }
            if (!house.getAddress().equals("")) {
                homeStay1.get().setAddress(house.getAddress());
            }
            if (house.getAmountBathRoom()!=null) {
                homeStay1.get().setAmountBathRoom(house.getAmountBathRoom());
            }
            if (house.getAmountBedRoom()!=null) {
                homeStay1.get().setAmountBedRoom(house.getAmountBedRoom());
            }
            if (!house.getDescription().equals("")) {
                homeStay1.get().setDescription(house.getDescription());
            }
            if (!house.getImageUrls().equals("")) {
                homeStay1.get().setImageUrls(house.getImageUrls());
            }
            houseService.save(homeStay1.get());
            return new ResponseEntity(homeStay1, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //tao moi 1 nha
    @PostMapping("/house")
    public ResponseEntity<House> createHouse(@RequestBody House house) {
        if (house.getCategoryHouse() != null) {
            String nameHouse = house.getCategoryHouse().getName();
            CategoryHouse categoryHouse = categoryHouseService.findByName(nameHouse);
            house.setCategoryHouse(categoryHouse);
        }
        houseService.save(house);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    //xoa 1 nha
    @DeleteMapping("/house/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional<House> homeStay1 = houseService.findById(id);
        if (homeStay1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        houseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //xem chi tiet 1 nha
    @GetMapping("/house/{id}")
    public ResponseEntity<House> findById(@PathVariable Long id) {
        Optional<House> homeStay = houseService.findById(id);
        if (homeStay == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(homeStay, HttpStatus.OK);
    }

    //tim kiem theo adress
    @PostMapping("/house/search")
    public ResponseEntity<Iterable<House>> listHouseInAdress(@RequestParam String address) {
        Iterable<House> houses = houseService.findAllByAddress(address);
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    //tao 1 phong trong nha id la id cua nha
    @PostMapping("house/{id}/room")
    public ResponseEntity<Iterable<House>> createRoomInHouse(@PathVariable("id") Long id, @RequestBody Room room) {
        Optional<House> house1 = houseService.findById(id);
        if (house1.isPresent()) {
            room.setNameHouse(house1.get().getNameHouse());
            room.setNameHost(house1.get().getHostName());
            roomService.save(room);
            house1.get().getRooms().add(room);
            houseService.save(house1.get());
            return new ResponseEntity(house1, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}