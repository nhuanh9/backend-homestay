package com.example.airbnb.service;

import com.example.airbnb.model.VerificationToken;

public interface VerificationTokenService {
    VerificationToken findByToken(String token);

    void save(VerificationToken token);
}