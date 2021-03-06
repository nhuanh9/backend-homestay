package com.example.airbnb.controller;


import com.example.airbnb.model.OrderForm;
import com.example.airbnb.model.Room;
import com.example.airbnb.service.OrderService;
import com.example.airbnb.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private OrderService orderService;

    private long oneDay = 86400000;

    //xem tat ca oder
    @GetMapping
    public ResponseEntity<Iterable<Room>> getAll() {
        Iterable<OrderForm> oderForms = orderService.findAll();
        return new ResponseEntity(oderForms, HttpStatus.OK);
    }

    @PostMapping("/search-by-house-name")
    public ResponseEntity<Iterable<Room>> getAllByHouseName(@RequestBody String houseName) {
        Iterable<OrderForm> oderForms = orderService.findAllByNameHouse(houseName);
        return new ResponseEntity(oderForms, HttpStatus.OK);
    }

    @PostMapping("/search-by-guest-name")
    public ResponseEntity<Iterable<Room>> getAllByGuestName(@RequestBody String nameGuest) {
        Iterable<OrderForm> oderForms = orderService.findAllByNameGuest(nameGuest);
        return new ResponseEntity(oderForms, HttpStatus.OK);
    }

    @PostMapping("/search-by-user-id")
    public ResponseEntity<Iterable<Room>> getAllByUserId(@RequestBody Long userId) {
        Iterable<OrderForm> oderForms = orderService.findAllByUserId(userId);
        return new ResponseEntity(oderForms, HttpStatus.OK);
    }

    //huy oder truoc 1 ngay
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Optional<OrderForm> orderForm = orderService.findById(id);
        if (orderForm == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        long orderTime = orderForm.get().getFormDate().getTime();
        long currentTime = date.getTime();
        long timeDemo = orderTime - currentTime;
        if (timeDemo > oneDay || timeDemo < 0) {
            orderService.delete(id);
        } else {
            return new ResponseEntity<>("Không thể xoá", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Thành Công", HttpStatus.OK);
    }


}
