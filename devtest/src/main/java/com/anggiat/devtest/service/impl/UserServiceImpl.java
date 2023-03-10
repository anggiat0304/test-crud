package com.anggiat.devtest.service.impl;

import com.anggiat.devtest.dto.UserUpdateDTO;
import com.anggiat.devtest.entity.UserModel;
import com.anggiat.devtest.exception.ResourceNotFoundException;
import com.anggiat.devtest.repository.UserRepository;
import com.anggiat.devtest.service.UserService;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Base64;
import java.util.Optional;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public String login(String phone) {
        Optional<UserModel> userModel = Optional.ofNullable(userRepository.findUserByPhone(phone));
        String token = Base64.getEncoder().encodeToString(phone.getBytes());
        if (userModel.isPresent()){
            UserModel updateUser = userModel.get();
            updateUser.setToken(token);
            return updateUser.getToken();
        }else{
            throw new ResourceNotFoundException("Record Not Found With Phone Number : " + phone);
        }

    }

    @Override
    public UserModel view(String token) {
        UserModel userModel = userRepository.findUserByToken(token);
        return userModel;
    }

    @Override
    public UserModel addUser(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(String token) {
        Optional<UserModel> userModel = Optional.ofNullable(userRepository.findUserByToken(token));
        if (userModel.isPresent()){
            userRepository.deleteById(userModel.get().getId());

            return "Akun berhasil dihapus";
        }else{
            throw new ResourceNotFoundException("Record Not Found With Token Number : " + token);
        }
    }

    @Override
    public String logout(String token) {
        Optional<UserModel> userModel = Optional.ofNullable(userRepository.findUserByToken(token));

        if (userModel.isPresent()){
            UserModel updateUser = userModel.get();
            updateUser.setToken(null);
            return "Berhasil logout";
        }else{
            throw new ResourceNotFoundException("");
        }
    }

    @Override
    public UserModel updateUser(UserUpdateDTO userBody , String token) {
        Optional<UserModel> userModel = Optional.ofNullable(userRepository.findUserByToken(token));
        if (userModel.isPresent()){
            UserModel updateUser = userModel.get();
            updateUser.setName(userBody.getName());
            updateUser.setPhone(userBody.getPhone());
            return updateUser;
        }else{
            throw new ResourceNotFoundException("Record Not Found With Phone Number : " + token);
        }
    }
}
