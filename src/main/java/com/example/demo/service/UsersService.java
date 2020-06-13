package com.example.demo.service;

import com.example.demo.entity.Users;
import com.example.demo.model.Login;

public interface UsersService extends BasicService<Users> {
	
	Users login(Login loginDetails);
	
}
