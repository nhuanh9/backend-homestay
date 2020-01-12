package com.example.airbnb.controller;


import com.example.airbnb.model.House;
import com.example.airbnb.model.Room;
import com.example.airbnb.service.HouseService;
import com.example.airbnb.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @GetMapping
    public ResponseEntity<Iterable<House>>listRomm(){
        Iterable<Room>rooms= roomService.findAll();
        return new ResponseEntity(rooms, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> edit(@PathVariable("id") Long id,@RequestBody Room room){
        Optional<Room> room1= roomService.findById(id);

        if(room1.isPresent()){
            room1.get().setNameHouse(room.getNameHouse());

            room1.get().setDescription(room.getDescription());
            room1.get().setImageUrls(room.getImageUrls());


            roomService.save(room1.get());
            return new ResponseEntity("thanh cong",HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<String>createRoom(@PathVariable("id") Long id,@RequestBody Room room){
        Optional<House>house1=houseService.findById(id);

        if (house1.isPresent()){
            roomService.save(room);
            house1.get().getRooms().add(room);
            houseService.save(house1.get());
            return new ResponseEntity("thanh cong",HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
