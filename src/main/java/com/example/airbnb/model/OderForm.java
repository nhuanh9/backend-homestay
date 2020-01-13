package com.example.airbnb.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;


@Entity

public class OderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeOder;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date formDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date toDate;

    public OderForm(Date timeOder,Date formDate, Date toDate) {
        this.timeOder=timeOder;
        this.formDate = formDate;
        this.toDate = toDate;
    }

    public OderForm() {
    }

    public Date getTimeOder() {
        return timeOder;
    }

    public void setTimeOder(Date timeOder) {
        this.timeOder = timeOder;
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