package com.creativedrive.cora.user.services;

import com.creativedrive.cora.user.beans.UserBean;

import java.util.List;

public interface UserService {

    List<UserBean> listUsers();

    UserBean save(UserBean userBean);

}
