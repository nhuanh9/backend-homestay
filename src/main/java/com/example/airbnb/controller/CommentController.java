package com.example.airbnb.controller;


import com.example.airbnb.model.CommentForm;
import com.example.airbnb.service.CommentService;
import com.example.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class CommentController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

}
