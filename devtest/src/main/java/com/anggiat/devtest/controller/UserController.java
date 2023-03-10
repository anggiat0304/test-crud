package com.anggiat.devtest.controller;

import com.anggiat.devtest.dto.UserUpdateDTO;
import com.anggiat.devtest.entity.UserModel;
import com.anggiat.devtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(@RequestParam String phone){
        return userService.login(phone);
    }
    @PostMapping("/add-user")
    public UserModel addUser(@RequestBody UserModel userModel){
        return userService.addUser(userModel);
    }

    @GetMapping("/view")
    public UserModel view(@RequestParam String token){
        return userService.view(token);
    }
    @DeleteMapping("/delete")
    public String delete(@RequestParam String token){
        return userService.deleteUser(token);
    }

    @GetMapping("/logout")
    public String logout(@RequestParam String token){
        return userService.logout(token);
    }

    @PostMapping("/edit-user")
    public UserModel editUser(@RequestParam String token,
                              @RequestBody UserUpdateDTO userUpdateDTO){
        return userService.updateUser(userUpdateDTO, token);
    }

}
