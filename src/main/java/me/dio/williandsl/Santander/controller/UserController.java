package me.dio.williandsl.Santander.controller;

import me.dio.williandsl.Santander.model.User;
import me.dio.williandsl.Santander.repository.UserRepository;
import me.dio.williandsl.Santander.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<User> create(@RequestBody User user) throws IllegalAccessException {
        User createdUser = userService.create(user);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(createdUser.getId())
                        .toUri())
                .body(createdUser);
    }

}
