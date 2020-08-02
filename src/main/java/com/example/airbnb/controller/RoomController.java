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
    public ResponseEntity<Iterable<Room>> getAll() {
        Iterable<Room> rooms = roomService.findAll();
        return new ResponseEntity(rooms, HttpStatus.OK);
    }

    //xem chi tiet 1 phong
    @GetMapping("/room/{id}")
    public ResponseEntity<String> getDetailById(@PathVariable Long id) {
        Optional<Room> room = roomService.findById(id);
        if (room == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(room, HttpStatus.OK);
    }

    //sua thong tin 1 phong
    @PutMapping("/room/{id}")
    public ResponseEntity<Iterable<Room>> edit(@PathVariable("id") Long id, @RequestBody Room newRoom) {
        Optional<Room> oldRoom = roomService.findById(id);
        if (oldRoom.isPresent()) {
            oldRoom.get().setNameRoom(newRoom.getNameRoom());
            oldRoom.get().setDescription(newRoom.getDescription());
            oldRoom.get().setImageUrls(newRoom.getImageUrls());
            oldRoom.get().setPriceRoom(newRoom.getPriceRoom());
            roomService.save(oldRoom.get());
            return new ResponseEntity(oldRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    final long SECONDS_ONE_DAY = 86400000;

    //oder 1 phong id la id cua phong
    @PostMapping("/room/{id}/user/{user_id}/order")
    public ResponseEntity<Iterable<Room>> createOrder(@PathVariable("id") Long id, @PathVariable("user_id") Long user_id, @RequestBody OrderForm orderForm) {
        orderForm.setStatusOder(StatusOder.WaitAccept);
        Optional<User> user = userService.findById(user_id);
        Optional<Room> room = roomService.findById(id);
        if (room.isPresent() && user.isPresent()) {
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            long fromDate = orderForm.getFormDate().getTime();
            long toDate = orderForm.getToDate().getTime();
            long timeOder = toDate - fromDate;
            long days = timeOder / SECONDS_ONE_DAY;
            Long price = room.get().getPriceRoom();
            orderForm.setTotal(days * price);
            orderForm.setTimeOrder(date);
            orderForm.setNameHouse(room.get().getNameHouse());
            orderService.save(orderForm);
            room.get().getOrderForms().add(orderForm);
            roomService.save(room.get());
            user.get().getListOrder().add(orderForm);
            userService.save(user.get());
            return new ResponseEntity(room, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //danh gia 1 phong
    @PostMapping("room/{id}/comments")
    public ResponseEntity<Optional<Room>> comment(@PathVariable("id") Long id, @RequestBody CommentForm commentForm) {
        commentService.save(commentForm);
        Optional<Room> room = roomService.findById(id);
        if (room.isPresent()) {
            room.get().getListComment().add(commentForm);
            roomService.save(room.get());
            return new ResponseEntity<>(room, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("room/search-by-house-name")
    public ResponseEntity<Iterable<Room>> getAllByHouseName(@RequestBody String nameHouse) {
        Iterable<Room> result = roomService.findAllByNameHouse(nameHouse);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
