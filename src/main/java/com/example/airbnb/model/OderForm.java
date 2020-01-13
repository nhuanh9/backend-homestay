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
    private Date formDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date toDate;

    public OderForm(Date formDate, Date toDate) {
        this.formDate = formDate;
        this.toDate = toDate;

    }

    public OderForm() {
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