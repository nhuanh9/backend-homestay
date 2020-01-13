package com.example.airbnb.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameHouse;
    private String nameHost;


    private String description;

    @Column(columnDefinition = "TEXT")
    private String imageUrls;

    @OneToMany(targetEntity = OderForm.class)
    private List<OderForm> oderForms;

    public Room(String nameHouse, String nameHost,  String description, String imageUrls) {
        this.nameHouse = nameHouse;
        this.nameHost = nameHost;

        this.description = description;
        this.imageUrls = imageUrls;
    }


    public Room() {
    }

    public List<OderForm> getOderForms() {
        return oderForms;
    }

    public void setOderForms(List<OderForm> oderForms) {
        this.oderForms = oderForms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameHouse() {
        return nameHouse;
    }

    public void setNameHouse(String nameHouse) {
        this.nameHouse = nameHouse;
    }

    public String getNameHost() {
        return nameHost;
    }

    public void setNameHost(String nameHost) {
        this.nameHost = nameHost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }



}
