package com.example.airbnb.controller;


import com.example.airbnb.model.*;
import com.example.airbnb.model.utility.StatusOder;
import com.example.airbnb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin("*")

public class RoomController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    //xem tat ca cac phong trong csdl
    @GetMapping("/room")
    public ResponseEntity<Iterable<Room>> listRomm() {
        Iterable<Room> rooms = roomService.findAll();
        return new ResponseEntity(rooms, HttpStatus.OK);
    }

    //xem chi tiet 1 phong
    @GetMapping("/room/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        Optional<Room> room = roomService.findById(id);
        if (room == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(room, HttpStatus.OK);
    }

    //sua thong tin 1 phong
    @PutMapping("/room/{id}")
    public ResponseEntity<Iterable<Room>> edit(@PathVariable("id") Long id, @RequestBody Room room) {
        Optional<Room> room1 = roomService.findById(id);
        if (room1.isPresent()) {
            room1.get().setNameRoom(room.getNameRoom());
            room1.get().setDescription(room.getDescription());
            room1.get().setImageUrls(room.getImageUrls());
            room1.get().setPriceRoom(room.getPriceRoom());
            roomService.save(room1.get());
            return new ResponseEntity(room1, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    private long oneDay = 86400000;

    //oder 1 phong id la id cua phong
    @PostMapping("/room/{id}/order")
    public ResponseEntity<Iterable<Room>> createOderRoom(@PathVariable("id") Long id, @RequestBody OrderForm orderForm) {
        orderForm.setStatusOder(StatusOder.WaitAccept);
        Optional<Room> room = roomService.findById(id);
        if (room.isPresent()) {
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            long fromDate = orderForm.getFormDate().getTime();
            long toDate = orderForm.getToDate().getTime();
            long timeOder = toDate - fromDate;
            long days = timeOder / oneDay;
            Long price = room.get().getPriceRoom();
            orderForm.setTotal(days * price);
            orderForm.setTimeOrder(date);
            orderService.save(orderForm);
            room.get().getOrderForms().add(orderForm);
            roomService.save(room.get());
            return new ResponseEntity(room, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //danh gia 1 phong
    @PostMapping("room/{id}/comments")
    public ResponseEntity<Optional<Room>> Comments(@PathVariable("id") Long id, @RequestBody CommentForm commentForm) {
        commentService.save(commentForm);
        Optional<Room> room = roomService.findById(id);
        if (room.isPresent()) {
            room.get().getListComment().add(commentForm);
            roomService.save(room.get());
            return new ResponseEntity<>(room,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
