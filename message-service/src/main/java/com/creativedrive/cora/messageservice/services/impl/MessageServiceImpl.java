package com.creativedrive.cora.messageservice.services.impl;

import com.creativedrive.cora.core.beans.MessageBean;
import com.creativedrive.cora.messageservice.documents.MessageDocument;
import com.creativedrive.cora.messageservice.repositories.MessageRepository;
import com.creativedrive.cora.messageservice.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Optional<List<MessageBean>> listMessage(String id) {
        return Optional.ofNullable(messageRepository.findByUser_Id(id).stream().map(this::toBean).collect(Collectors.toList()));
    }

    @Override
    public Optional<MessageBean> save(MessageBean message) {
        MessageDocument document = messageRepository.save(toDocument(message));
        return Optional.ofNullable(toBean(document));
    }

    /**
     * Converter Documento para Bean
     *
     * @param document
     * @return
     */
    private MessageBean toBean(MessageDocument document) {
        return MessageBean.builder()
                .id(document.getId())
                .user(document.getUser())
                .message(document.getMessage())
                .build();
    }

    /**
     * Converte Bean para Documento
     *
     * @param message
     * @return
     */
    private MessageDocument toDocument(MessageBean message) {
        return MessageDocument.builder()
                .id(message.getId())
                .user(message.getUser())
                .message(message.getMessage())
                .build();
    }
}
