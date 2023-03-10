package com.anggiat.devtest.service;

import com.anggiat.devtest.dto.UserUpdateDTO;
import com.anggiat.devtest.entity.UserModel;
import org.apache.catalina.User;

public interface UserService {
    String login(String phone);

    UserModel view(String token);

    UserModel addUser(UserModel user);

    String deleteUser(String token);

    String logout(String token);

    UserModel updateUser(UserUpdateDTO userModel, String token);
}
