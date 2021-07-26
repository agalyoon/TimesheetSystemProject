package com.training.disasterproject.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.training.disasterproject.model.User;
import com.training.disasterproject.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
