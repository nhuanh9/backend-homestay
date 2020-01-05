package com.example.airbnb.controller;


import com.example.airbnb.model.CategoryRoom;
import com.example.airbnb.service.CategoryRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")

@RequestMapping("/category/room")

public class CategoryRoomController {
    @Autowired
    private CategoryRoomService categoryRoomService;

    @GetMapping

    public ResponseEntity<Iterable<CategoryRoom>>listCategoryRoom(){
        Iterable<CategoryRoom>categoryRooms=categoryRoomService.findAll();
        return new ResponseEntity<>(categoryRooms, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CategoryRoom>createCategoryRoom(@RequestBody CategoryRoom categoryRoom){
        categoryRoomService.save(categoryRoom);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryRoom>editCategoryRoom(@PathVariable("id") Long id, @RequestBody CategoryRoom categoryRoom){
        Optional<CategoryRoom>categoryRoom1=categoryRoomService.findById(id);
        if(categoryRoom1.isPresent()){
            categoryRoom1.get().setName(categoryRoom.getName());

            categoryRoomService.save(categoryRoom1.get());
            return new ResponseEntity("thanh cong",HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
