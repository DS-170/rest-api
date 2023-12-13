package com.developers.kameleoon.restapi.service;

import com.developers.kameleoon.restapi.dto.UserDTO;
import com.developers.kameleoon.restapi.models.User;
import com.developers.kameleoon.restapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(UserDTO dto) {
        Date currentDate = new Date();

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .creationDate(currentDate)
                .build();
        return userRepository.save(user);
    }

    public List<User> readAll() {
        return userRepository.findAll();
    }

    public User readById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found - ID: " + id));
    }
}
