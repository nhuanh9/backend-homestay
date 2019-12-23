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
        CategoryRoom categoryRoom = categoryRoomService.findByNameRoom(name);
        homeStay.setCategoryRoom(categoryRoom);
        }
        if (homeStay.getCategoryHouse() != null){
            String nameHouse=homeStay.getCategoryHouse().getName();
            CategoryHouse categoryHouse=categoryHouseService.findByName(nameHouse);
            homeStay.setCategoryHouse(categoryHouse);
        }
        if (homeStay.getPrice()!=null){
            Price price=homeStay.getPrice();
            priceService.save(price);
        }
        homeStayService.save(homeStay);



        return new ResponseEntity<>(HttpStatus.CREATED);

}
    @PutMapping("/{id}")
    public ResponseEntity<Void> edit(@PathVariable("id") Long id,@RequestBody HomeStay homeStay){
        Optional<HomeStay>homeStay1= homeStayService.findById(id);

        if(homeStay1.isPresent()){
            homeStay1.get().setNameHouse(homeStay.getNameHouse());
            homeStay1.get().setCategoryHouse(homeStay.getCategoryHouse());
            homeStay1.get().setCategoryRoom(homeStay.getCategoryRoom());
            homeStay1.get().setAddress(homeStay.getAddress());
            homeStay1.get().setAmountBathRoom(homeStay.getAmountBathRoom());
            homeStay1.get().setAmountBedRoom(homeStay.getAmountBedRoom());
            homeStay1.get().setDescription(homeStay.getDescription());
            homeStay1.get().setImageUrls(homeStay.getImageUrls());
            homeStay1.get().setPrice(homeStay.getPrice());

            homeStayService.save(homeStay1.get());
            return new ResponseEntity("thanh cong",HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        Optional<HomeStay> homeStay1 = homeStayService.findById(id);
        if (homeStay1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        homeStayService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}