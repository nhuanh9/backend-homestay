package com.example.airbnb.model;

import com.example.airbnb.model.utility.StatusOder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;


@Entity

public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameGuest;

    private Long phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeOrder;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date formDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;


    private Long total;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Enumerated(EnumType.STRING)
    private StatusOder statusOder;

    public OrderForm(String nameGuest, Long phoneNumber, Date timeOrder, Date formDate, Date toDate, Long total, StatusOder statusOder,User user) {
        this.timeOrder = timeOrder;
        this.formDate = formDate;
        this.toDate = toDate;
        this.total = total;
        this.nameGuest = nameGuest;
        this.phoneNumber = phoneNumber;
        this.statusOder = statusOder;
        this.user=user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StatusOder getStatusOder() {
        return statusOder;
    }

    public void setStatusOder(StatusOder statusOder) {
        this.statusOder = statusOder;
    }

    public OrderForm() {
    }

    public String getNameGuest() {
        return nameGuest;
    }

    public void setNameGuest(String nameGuest) {
        this.nameGuest = nameGuest;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Date getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Date timeOrder) {
        this.timeOrder = timeOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFormDate() {
        return formDate;
    }

    public void setFormDate(Date formDate) {
        this.formDate = formDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}