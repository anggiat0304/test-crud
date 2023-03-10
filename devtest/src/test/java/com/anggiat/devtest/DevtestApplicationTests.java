package com.anggiat.devtest;

import com.anggiat.devtest.dto.UserUpdateDTO;
import com.anggiat.devtest.entity.UserModel;
import com.anggiat.devtest.repository.UserRepository;
import com.anggiat.devtest.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Base64;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class DevtestApplicationTests {
	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;
	@Test
	public void addUserTest() {
		String phone="082164462644";
		String token = Base64.getEncoder().encodeToString(phone.getBytes());
		UserModel userModel = new UserModel();
		userModel.setName("Coky");
		userModel.setPhone(phone);
		userModel.setToken(null);
		Mockito.when(userRepository.save(userModel)).thenReturn(userModel);
		assertEquals(userModel,userService.addUser(userModel));
	}
	@Test
	public void loginTest() {
		String phone="082164462644";
		String token = Base64.getEncoder().encodeToString(phone.getBytes());
		UserModel userModel = new UserModel();
		userModel.setName("Coky");
		userModel.setPhone(phone);
		userModel.setToken(token);
		Mockito.when(userRepository.findUserByPhone(phone)).thenReturn(userModel);
		assertEquals(token,userService.login(phone));
	}
	@Test
	public void viewTest() {
		String phone="082164462644";
		String token = Base64.getEncoder().encodeToString(phone.getBytes());
		UserModel userModel = new UserModel();
		userModel.setName("Coky");
		userModel.setPhone(phone);
		userModel.setToken(token);
		Mockito.when(userRepository.findUserByToken(token)).thenReturn(userModel);
		assertEquals(userModel,userService.view(token));
	}

	@Test
	public void updateTest() {
		String phone="082164462644";
		String token = Base64.getEncoder().encodeToString(phone.getBytes());
		UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
		userUpdateDTO.setName("Coky");
		userUpdateDTO.setPhone(phone);

		UserModel userModel = new UserModel();
		userModel.setName("coky");
		userModel.setPhone(phone);
		userModel.setToken(token);
		Mockito.when(userRepository.findUserByToken(token)).thenReturn(userModel);
		assertEquals(userModel,userService.updateUser(userUpdateDTO,token));
	}

	@Test
	public void logoutTest() {
		String phone="082164462644";
		String token = Base64.getEncoder().encodeToString(phone.getBytes());
		UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
		userUpdateDTO.setName("Coky");
		userUpdateDTO.setPhone(phone);

		UserModel userModel = new UserModel();
		userModel.setName("coky");
		userModel.setPhone(phone);
		userModel.setToken(token);
		Mockito.when(userRepository.findUserByToken(token)).thenReturn(userModel);
		assertEquals("Berhasil logout",userService.logout(token));
	}

	@Test
	public void deleteTest() {
		String phone="082164462644";
		String token = Base64.getEncoder().encodeToString(phone.getBytes());
		UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
		userUpdateDTO.setName("Coky");
		userUpdateDTO.setPhone(phone);

		UserModel userModel = new UserModel();
		userModel.setName("coky");
		userModel.setPhone(phone);
		userModel.setToken(token);
		Mockito.when(userRepository.findUserByToken(token)).thenReturn(userModel);
		assertEquals("Akun berhasil dihapus",userService.deleteUser(token));
	}
}
