package com.example.airbnb.model;



import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hostName;

    private String nameHouse;
    @ManyToOne
    @JoinColumn(name = "category_home")
    private CategoryHouse categoryHouse;


    private Long amountBathRoom;
    private Long amountBedRoom;
    private String address;
    private String description;

    @Column(columnDefinition = "TEXT")
    private String imageUrls;

    @OneToMany(targetEntity = Room.class)
    private List<Room> rooms;



    public House() {
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public House(String hostName, String nameHouse, CategoryHouse categoryHouse, Long amountBathRoom, Long amountBedRoom, String address, String description,  String imageUrls) {
        this.hostName=hostName;
        this.nameHouse = nameHouse;
        this.categoryHouse = categoryHouse;
        this.amountBathRoom = amountBathRoom;
        this.amountBedRoom = amountBedRoom;
        this.address = address;
        this.description = description;
        this.imageUrls = imageUrls;

    }



    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
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

    public CategoryHouse getCategoryHouse() {
        return categoryHouse;
    }

    public void setCategoryHouse(CategoryHouse categoryHouse) {
        this.categoryHouse = categoryHouse;
    }



    public Long getAmountBathRoom() {
        return amountBathRoom;
    }

    public void setAmountBathRoom(Long amountBathRoom) {
        this.amountBathRoom = amountBathRoom;
    }

    public Long getAmountBedRoom() {
        return amountBedRoom;
    }

    public void setAmountBedRoom(Long amountBedRoom) {
        this.amountBedRoom = amountBedRoom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
