package com.github.prgrms.socialserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.prgrms.socialserver.domain.Users;
import com.github.prgrms.socialserver.service.JdbcUsersRepository;

@Controller
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	JdbcUsersRepository jdbcUsersRepository;

	@RequestMapping("/list")
	public String allUsers(Model model) throws JsonProcessingException {
		ObjectMapper obm = new ObjectMapper();
		List<Users> users = jdbcUsersRepository.allUsers();
		String jsonString = obm.writeValueAsString(users);

		model.addAttribute("users", jdbcUsersRepository.allUsers());
		model.addAttribute("jsonString", jsonString);
		 return "Users/list";
	}
	
	@GetMapping("/{userId}")
	public String getUser(@PathVariable String userId, Model model) {
		model.addAttribute("user", jdbcUsersRepository.findById(userId));
		return "Users/user";
	}
	
	@GetMapping("/addUser")
	public String addUser() {
		return "Users/add";
	}
	
	@PostMapping("/addUser")
	public String addUser(Users user,Model model){
		System.out.println("user:"+user);
		
		Long retVal= jdbcUsersRepository.save(new Users(user.getUserId(), user.getEmail(), user.getPasswd()));
		System.out.println("retVal:"+retVal);
		model.addAttribute("user", jdbcUsersRepository.findById(user.getUserId()));
		return "Users/user";
	}
}
