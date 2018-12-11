package com.creativedrive.cora.user.controllers;

import com.creativedrive.cora.core.beans.UserBean;
import com.creativedrive.cora.user.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserBean> listUsers() {
        log.info("Consulting list user...");
        return userService.listUsers().get();
    }

    @GetMapping("/with-message")
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserBean> listUsersWithMessages() {
        log.info("Consulting list user with messages...");
        return userService.listUsers().get();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserBean save(@RequestBody @Valid UserBean user) {
        log.info("Saving new user...");
        return userService.save(user).get();
    }

}
