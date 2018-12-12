package com.creativedrive.cora.user.services.impl;

import com.creativedrive.cora.core.beans.MessageBean;
import com.creativedrive.cora.core.beans.UserBean;
import com.creativedrive.cora.user.clients.MessageClient;
import com.creativedrive.cora.user.documents.UserDocument;
import com.creativedrive.cora.user.repositories.UserRepository;
import com.creativedrive.cora.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageClient messageClient;

    @Override
    public Optional<List<UserBean>> listUsers() {
        Optional<List<UserBean>> list = Optional.ofNullable(userRepository.findAll().stream().map(this::toBean).collect(Collectors.toList()));
        if (list.isPresent()) {
            list.get().stream().forEach(user -> {
                List<MessageBean> messages = messageClient.listMessagesByUser(user.getId());
                messages.stream().forEach(messageBean -> messageBean.setUser(null));
                user.setMessage(messages);
            });
        }
        return Optional.ofNullable(userRepository.findAll().stream().map(this::toBean).collect(Collectors.toList()));
    }

    @Override
    public Optional<UserBean> save(UserBean user) {
        UserDocument document = userRepository.save(toDocument(user));
        return Optional.ofNullable(toBean(document));
    }

    /**
     * Converter Documento para Bean
     *
     * @param document
     * @return
     */
    private UserBean toBean(UserDocument document) {
        return UserBean.builder().id(document.getId()).nome(document.getNome()).email(document.getEmail())
                .endereco(document.getEndereco()).telefone(document.getTelefone())
                .perfil(document.getPerfil())
                .build();
    }

    /**
     * Converte Bean para Documento
     *
     * @param user
     * @return
     */
    private UserDocument toDocument(UserBean user) {
        return UserDocument.builder().id(user.getId()).nome(user.getNome()).email(user.getEmail())
                .endereco(user.getEndereco()).telefone(user.getTelefone())
                .perfil(user.getPerfil())
                .build();
    }
}
