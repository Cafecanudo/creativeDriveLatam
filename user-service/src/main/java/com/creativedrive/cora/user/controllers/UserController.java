package com.creativedrive.cora.user.controllers;

import com.creativedrive.cora.user.beans.UserBean;
import com.creativedrive.cora.user.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserBean> listUsers() {
        return userService.listUsers();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserBean save(@RequestBody @Valid UserBean userBean) {
        return userService.save(userBean);
    }

}
