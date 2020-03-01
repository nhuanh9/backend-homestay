package com.example.airbnb.controller;


import com.example.airbnb.model.House;
import com.example.airbnb.model.OderForm;
import com.example.airbnb.model.Room;
import com.example.airbnb.model.utility.StatusOder;
import com.example.airbnb.service.OderService;
import com.example.airbnb.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/oder")
public class OderController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private OderService oderService;

    private long oneDay = 86400000;

    //xem tat ca oder
    @GetMapping
    public ResponseEntity<Iterable<Room>> listOder() {
        Iterable<OderForm> oderForms = oderService.findAll();
        return new ResponseEntity(oderForms, HttpStatus.OK);
    }

    //huy oder truoc 1 ngay
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Optional<OderForm> oderForm = oderService.findById(id);
        if (oderForm == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        long oderTime = oderForm.get().getFormDate().getTime();
        long currentTime = date.getTime();
        long timeDemo = oderTime - currentTime;
        if (timeDemo > oneDay || timeDemo < 0) {
            oderService.delete(id);
        } else {
            return new ResponseEntity<>("khong duoc xoa", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("thanh cong", HttpStatus.OK);
    }

    //thay doi trang thai oder
   /* @PutMapping("/{id}")
    public ResponseEntity<Optional<OderForm>> edit(@PathVariable("id") Long id, @RequestBody OderForm oderForm) {
        Optional<OderForm> oderForm1 = oderService.findById(id);
        if (oderForm1.isPresent()) {
            if (oderForm.getStatusOder() == StatusOder.Accept || oderForm.getStatusOder() == StatusOder.Cancel) {
                oderForm1.get().setStatusOder(oderForm.getStatusOder());
                oderService.save(oderForm1.get());
            }

            return new ResponseEntity(oderForm1, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
*/
}
