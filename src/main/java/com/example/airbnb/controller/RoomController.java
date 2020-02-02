package com.example.airbnb.controller;


import com.example.airbnb.model.House;
import com.example.airbnb.model.OderForm;
import com.example.airbnb.model.Role;
import com.example.airbnb.model.Room;
import com.example.airbnb.service.HouseService;
import com.example.airbnb.service.OderService;
import com.example.airbnb.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin("*")

public class RoomController {
    @Autowired
    private OderService oderService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private HouseService houseService;
    //xem tat ca cac phong trong csdl
    @GetMapping("/room")
    public ResponseEntity<Iterable<Room>>listRomm(){
        Iterable<Room>rooms= roomService.findAll();
        return new ResponseEntity(rooms, HttpStatus.OK);
    }
    //xem chi tiet 1 phong
    @GetMapping("/room/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id){
        Optional<Room> room = roomService.findById(id);
        if (room == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(room, HttpStatus.OK);
    }
    //sua thong tin 1 phong
    @PutMapping("/room/{id}")
    public ResponseEntity<Iterable<Room>> edit(@PathVariable("id") Long id,@RequestBody Room room){
        Optional<Room> room1= roomService.findById(id);
        if(room1.isPresent()){
            room1.get().setNameRoom(room.getNameRoom());
            room1.get().setDescription(room.getDescription());
            room1.get().setImageUrls(room.getImageUrls());
            room1.get().setPriceRoom(room.getPriceRoom());
            roomService.save(room1.get());
            return new ResponseEntity(room1,HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    private long oneDay=86400000;
    //oder 1 phong id la id cua phong
    @PostMapping("/room/{id}/oder")
    public ResponseEntity<Iterable<Room>> createOderRoom(@PathVariable("id") Long id, @RequestBody OderForm oderForm){
        Optional<Room> room=roomService.findById(id);

        if (room.isPresent()){
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            long fromDate=oderForm.getFormDate().getTime();
            long toDate=oderForm.getToDate().getTime();
            long timeOder=toDate-fromDate;
            long days=timeOder/oneDay;
            Long price=room.get().getPriceRoom();
            oderForm.setTotal(days*price);
            oderForm.setTimeOder(date);
            oderService.save(oderForm);
            room.get().getOderForms().add(oderForm);
            roomService.save(room.get());
            return new ResponseEntity(room, HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }




}
