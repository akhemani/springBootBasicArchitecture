package com.example.demo.controller;

import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.Message;
import com.example.demo.common.Response;
import com.example.demo.common.ResultCode;
import com.example.demo.entity.Users;
import com.example.demo.model.Login;
import com.example.demo.service.UsersService;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UsersService usersService;

	@PostMapping("login")
	public ResponseEntity<Response> login(@RequestBody Login loginDetails) {
		
		Users users = usersService.login(loginDetails);
		
		if (users != null) {
			return new ResponseEntity<>(new Response(ResultCode.SUCCESS, users, Message.SUCCESS), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Response(ResultCode.SUCCESS, users, Message.INVALID), HttpStatus.OK);
		}
	}
	
}
