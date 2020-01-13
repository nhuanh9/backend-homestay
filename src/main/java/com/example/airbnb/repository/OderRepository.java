package com.example.airbnb.repository;

import com.example.airbnb.model.OderForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderRepository extends JpaRepository<OderForm,Long> {
}
