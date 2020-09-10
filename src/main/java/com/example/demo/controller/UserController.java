package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.UserVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
	
	private static final Logger logger = Logger.getLogger("UserController.class");
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping
	public List<UserVO> userList(){	
		return userMapper.userList();
	}
	
	@PostMapping
	public void insertUser(@RequestBody UserVO user) {
		
		logger.info("insertUser()");		
		userMapper.insertUser(user);
	}
	
	@GetMapping("/{id}")
	public UserVO fetchUserByID(@PathVariable int id) {
		
		logger.info("fetchUserByID()");
		UserVO fetchUser = userMapper.fetchUserByID(id);
		
		return fetchUser;
	}
	
	@PutMapping("/{id}")
	public void updateUser(@PathVariable int id, @RequestBody UserVO user) {
		
		logger.info("updateUser()");
		UserVO updateUser = user;
		
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setAge(user.getAge());
		updateUser.setSalary(user.getSalary());
		
		userMapper.updateUser(updateUser);
	}
	
	@DeleteMapping("/{id}")
	public void deleteuser(@PathVariable int id) {
		logger.info("deleteUser()");
		userMapper.deleteUser(id);		
	}
	
}
