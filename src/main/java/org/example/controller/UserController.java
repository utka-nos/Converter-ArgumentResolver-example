package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.User;
import org.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public User saveUser(
            @RequestBody User user
    ){
        User savedUser = userRepo.save(user);
        log.info("Saved user : {{}}", savedUser);
        return savedUser;
    }

    @GetMapping("/{id}")
    public User getUser(
        @PathVariable("id") User user
    ) {
        return user;
    }

}
