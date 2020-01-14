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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeOder;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date formDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

    private Long total;


    public OderForm(Date timeOder,Date formDate, Date toDate,Long total) {
        this.timeOder=timeOder;
        this.formDate = formDate;
        this.toDate = toDate;
        this.total=total;
    }

    public OderForm() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
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