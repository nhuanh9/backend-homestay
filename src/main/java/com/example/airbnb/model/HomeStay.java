package com.example.airbnb.model;



import javax.persistence.*;


@Entity
public class HomeStay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameHouse;

    @ManyToOne
    @JoinColumn(name = "category_house")

    private CategoryHouse categoryHouse;
    @ManyToOne
    @JoinColumn(name = "category_room")

    private CategoryRoom categoryRoom;
    private Long amountBathRoom;
    private Long amountBedRoom;
    private String address;


    @OneToOne
    @JoinColumn(name = "price")
    private Price price;


    private String imageUrls;

    public HomeStay() {
    }

    public HomeStay(String nameHouse, CategoryHouse categoryHouse, CategoryRoom categoryRoom, Long amountBathRoom, Long amountBedRoom, String address, Price price, String imageUrls) {
        this.nameHouse = nameHouse;
        this.categoryHouse = categoryHouse;
        this.categoryRoom = categoryRoom;
        this.amountBathRoom = amountBathRoom;
        this.amountBedRoom = amountBedRoom;
        this.address = address;

        this.price = price;
        this.imageUrls = imageUrls;
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

    public CategoryRoom getCategoryRoom() {
        return categoryRoom;
    }

    public void setCategoryRoom(CategoryRoom categoryRoom) {
        this.categoryRoom = categoryRoom;
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



    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }
}
