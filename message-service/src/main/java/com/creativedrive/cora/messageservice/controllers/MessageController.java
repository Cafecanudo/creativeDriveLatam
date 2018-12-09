package com.creativedrive.cora.messageservice.controllers;

import com.creativedrive.cora.core.beans.MessageBean;
import com.creativedrive.cora.messageservice.services.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Slf4j
@RestController("message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<MessageBean> listUsers(@NotNull(message = "Id required") @PathVariable @Size(max = 60, message = "Max 60 characters") String id) {
        log.info("Consulting list messages...");
        return messageService.listMessage(id).get();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageBean save(@RequestBody @Valid MessageBean message) {
        log.info("Saving message...");
        return messageService.save(message).get();
    }
}
