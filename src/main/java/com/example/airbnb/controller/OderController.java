package com.example.airbnb.controller;


import com.example.airbnb.model.House;
import com.example.airbnb.model.OderForm;
import com.example.airbnb.model.Room;
import com.example.airbnb.service.OderService;
import com.example.airbnb.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/oder")
public class OderController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private OderService oderService;
    @PostMapping("room/{id}")
    public ResponseEntity<String> createOderRoom(@PathVariable("id") Long id, @RequestBody OderForm oderForm){
        Optional<Room> room=roomService.findById(id);

        if (room.isPresent()){
            oderService.save(oderForm);
            room.get().getOderForms().add(oderForm);
            roomService.save(room.get());
            return new ResponseEntity("thanh cong", HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
