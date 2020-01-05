package com.example.airbnb.service.impl;

import com.example.airbnb.model.Role;
import com.example.airbnb.repository.RoleRepository;
import com.example.airbnb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void save(Role role) {
roleRepository.save(role);
    }

    @Override
    public Optional<Role> findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
