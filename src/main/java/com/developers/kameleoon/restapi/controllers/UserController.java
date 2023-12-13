package com.developers.kameleoon.restapi.controllers;

import com.developers.kameleoon.restapi.dto.UserDTO;
import com.developers.kameleoon.restapi.models.User;
import com.developers.kameleoon.restapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public User create(@RequestBody UserDTO dto) {
        return userService.create(dto);
    }

    @GetMapping
    public List<User> readAll() {
        return userService.readAll();
    }

    @GetMapping("/{id}")
    public User readById(@PathVariable Long id) {
        return userService.readById(id);
    }

//    @PutMapping
//    public ResponseEntity<User> update(@RequestBody User user) {
//        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
//    }

//    @DeleteMapping("/{id}")
//    public HttpStatus delete(@PathVariable Long id) {
//        userService.delete(id);
//        return HttpStatus.OK;
//    }
}
