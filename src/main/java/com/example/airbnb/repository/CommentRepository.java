package com.example.airbnb.repository;

import com.example.airbnb.model.CommentForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentForm,Long> {
}
