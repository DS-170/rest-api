package com.developers.kameleoon.restapi.controllers;

import com.developers.kameleoon.restapi.dto.UserDTO;
import com.developers.kameleoon.restapi.models.Quote;
import com.developers.kameleoon.restapi.models._User;
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
    public ResponseEntity<_User> create(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(userService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<_User>> readAll() {
        return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<_User> readById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.readById(id), HttpStatus.OK);
    }

//    @PutMapping
//    public ResponseEntity<_User> update(@RequestBody _User user) {
//        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
//    }

//    @DeleteMapping("/{id}")
//    public HttpStatus delete(@PathVariable Long id) {
//        userService.delete(id);
//        return HttpStatus.OK;
//    }
}
