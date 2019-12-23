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

    private String nightly;
    private  String weekend;


    public Price() {
    }

    public Price(String nightly, String weekend) {
        this.nightly = nightly;
        this.weekend = weekend;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNightly() {
        return nightly;
    }

    public void setNightly(String nightly) {
        this.nightly = nightly;
    }

    public String getWeekend() {
        return weekend;
    }

    public void setWeekend(String weekend) {
        this.weekend = weekend;
    }



}
