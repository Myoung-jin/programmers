package com.github.prgrms.socialserver.service;

import java.util.List;
import java.util.Map;

import com.github.prgrms.socialserver.domain.Users;

public interface UserRepository { 

	int count();
	Long save(Users user);
	int update(Users user);
	int delete(String userId);
	void deleteAll();
	List<Users> allUsers();
	Users findById(String userId);
	Users findByEmail(String email);
}
