package com.example.airbnb.service;


import com.example.airbnb.model.Role;
import com.example.airbnb.model.RoleName;

import java.util.Optional;


public interface RoleService {
    Iterable<Role> findAll();


    void save(Role role);

    Optional<Role> findByName(RoleName roleName);
}
