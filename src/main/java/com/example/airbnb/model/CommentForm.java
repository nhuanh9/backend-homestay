package com.example.airbnb.model;

import javax.persistence.*;
@Entity
public class CommentForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    private String username;

    @Column(columnDefinition = "TEXT")
    private String imageUrls;

    public CommentForm(String comment, String username,String imageUrls) {
        this.comment = comment;
        this.username = username;
        this.imageUrls = imageUrls;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public CommentForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
