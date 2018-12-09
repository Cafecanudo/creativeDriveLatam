package com.creativedrive.cora.messageservice.services;

import com.creativedrive.cora.core.beans.MessageBean;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    Optional<List<MessageBean>> listMessage(String id);

    Optional<MessageBean> save(MessageBean message);
}
