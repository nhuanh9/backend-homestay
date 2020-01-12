package com.example.airbnb.model;

import javax.persistence.*;

@Entity

public class CategoryRoom {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;


    public CategoryRoom(String name) {
        this.name = name;
    }

    public CategoryRoom() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
