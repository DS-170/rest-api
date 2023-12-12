package com.developers.kameleoon.restapi.service;

import com.developers.kameleoon.restapi.dto.UserDTO;
import com.developers.kameleoon.restapi.models.Quote;
import com.developers.kameleoon.restapi.models._User;
import com.developers.kameleoon.restapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public _User create(UserDTO dto) {
        Date currentDate = new Date();

        _User user = _User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .creationDate(currentDate)
                .build();
        return userRepository.save(user);
    }

    public List<_User> readAll() {
        return userRepository.findAll();
    }

    public _User readById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found - ID: " + id));
    }

//    public _User update(_User user) {
//        return userRepository.save(user);
//    }

//    public void delete(Long id) {
//        userRepository.deleteById(id);
//    }
}
