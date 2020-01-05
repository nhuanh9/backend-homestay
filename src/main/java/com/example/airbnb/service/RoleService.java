package com.example.airbnb.service;

import com.example.airbnb.model.CategoryHouse;
import com.example.airbnb.model.Role;

import java.util.Optional;

public interface RoleService {
    Iterable<Role> findAll();

    Optional<Role> findById(Long id);

    void save(Role role);

    Optional<Role> findByName(String roleName);
}
