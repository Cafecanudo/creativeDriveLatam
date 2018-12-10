package com.creativedrive.cora.user.controllers;

import com.creativedrive.cora.core.beans.MessageBean;
import com.creativedrive.cora.core.beans.UserBean;
import com.creativedrive.cora.user.clients.MessageClient;
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

    @Autowired
    private MessageClient messageClient;

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
        List<UserBean> users = userService.listUsers().get();
        users.stream().forEach(user -> {
            List<MessageBean> messages = messageClient.listMessagesByUser(user.getId());
            messages.stream().forEach(messageBean -> messageBean.setUser(null));
            user.setMessage(messages);
        });
        return users;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserBean save(@RequestBody @Valid UserBean user) {
        log.info("Saving new user...");
        return userService.save(user).get();
    }

}
