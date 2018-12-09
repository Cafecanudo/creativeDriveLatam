package com.creativedrive.cora.user.services;

import com.creativedrive.cora.core.beans.UserBean;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<List<UserBean>> listUsers();

    Optional<UserBean> save(UserBean user);

}
