package com.example.airbnb.controller;


import com.example.airbnb.model.House;
import com.example.airbnb.model.Role;
import com.example.airbnb.model.Room;
import com.example.airbnb.service.HouseService;
import com.example.airbnb.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private HouseService houseService;
    //xem tat ca cac phong trong csdl
    @GetMapping
    public ResponseEntity<Iterable<Room>>listRomm(){
        Iterable<Room>rooms= roomService.findAll();
        return new ResponseEntity(rooms, HttpStatus.OK);
    }
    //xem chi tiet 1 phong
    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id){
        Optional<Room> room = roomService.findById(id);
        if (room == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(room, HttpStatus.OK);
    }
    //sua thong tin 1 phong
    @PutMapping("/{id}")
    public ResponseEntity<Iterable<Room>> edit(@PathVariable("id") Long id,@RequestBody Room room){
        Optional<Room> room1= roomService.findById(id);
        if(room1.isPresent()){
            room1.get().setDescription(room.getDescription());
            room1.get().setImageUrls(room.getImageUrls());
            room1.get().setPriceRoom(room.getPriceRoom());
            roomService.save(room1.get());
            return new ResponseEntity(room1,HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    //tao 1 phong trong nha id la id cua nha
    @PostMapping("house/{id}")
    public ResponseEntity<Iterable<House>>createRoomInHouse(@PathVariable("id") Long id,@RequestBody Room room){
        Optional<House>house1=houseService.findById(id);

        if (house1.isPresent()){
            room.setNameHouse(house1.get().getNameHouse());
            room.setNameHost(house1.get().getHostName());
            roomService.save(room);
            house1.get().getRooms().add(room);
            houseService.save(house1.get());
            return new ResponseEntity(house1,HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
