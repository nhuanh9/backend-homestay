package com.example.airbnb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String namePrice;



    public Price() {
    }

    public Price(String namePrice) {
        this.namePrice = namePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePrice() {
        return namePrice;
    }

    public void setNamePrice(String namePrice) {
        this.namePrice = namePrice;
    }
}
