package com.creativedrive.cora.user.services.impl;

import com.creativedrive.cora.user.beans.UserBean;
import com.creativedrive.cora.user.documents.UserDocument;
import com.creativedrive.cora.user.repositories.UserRepository;
import com.creativedrive.cora.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserBean> listUsers() {
        return userRepository.findAll().stream().map(this::converterParaBean).collect(Collectors.toList());
    }

    @Override
    public UserBean save(UserBean userBean) {
        UserDocument document = userRepository.save(converterParaDocumento(userBean));
        return converterParaBean(document);
    }

    /**
     * Converter Documento para Bean
     *
     * @param document
     * @return
     */
    private UserBean converterParaBean(UserDocument document) {
        return UserBean.builder().id(document.getId()).nome(document.getNome()).email(document.getEmail())
                .endereco(document.getEndereco()).telefone(document.getTelefone())
                .perfil(document.getPerfil())
                .build();
    }

    /**
     * Converte Bean para Documento
     *
     * @param bean
     * @return
     */
    private UserDocument converterParaDocumento(UserBean bean) {
        return UserDocument.builder().id(bean.getId()).nome(bean.getNome()).email(bean.getEmail())
                .endereco(bean.getEndereco()).telefone(bean.getTelefone())
                .perfil(bean.getPerfil())
                .build();
    }
}
