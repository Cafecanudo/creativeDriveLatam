package com.creativedrive.cora.user.clients;

import com.creativedrive.cora.core.beans.MessageBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Component
@FeignClient(name = "gateway-service", path = "/api")
public interface MessageClient {

    @GetMapping("/message/{userID}")
    List<MessageBean> listMessagesByUser(@NotNull(message = "Id required") @Size(max = 60, message = "Max 60 characters") @PathVariable("userID") String userID);
}
