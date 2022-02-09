package com.mobile.rest.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.rest.dto.UserDto;
import com.mobile.rest.model.reqest.UserReqModel;
import com.mobile.rest.model.responce.UserReqResponce;
import com.mobile.rest.service.UserService;



@RestController
@RequestMapping("users") // This maps to https://localhost:8084/users
public class UserController {

	@Autowired
	public UserService userService;
	@GetMapping
	public String getUsers()
	{
		return "This gets all the users";
	}
	
	@PostMapping
	public UserReqResponce postUser(@RequestBody UserReqModel userbody)
	{
		
		UserReqResponce returnValue=new UserReqResponce();
		
		UserDto userDtoObj=new UserDto();
		
		BeanUtils.copyProperties(userbody,userDtoObj);
		System.out.println("hello");
		UserDto userDtoObjRes=userService.createUser(userDtoObj);
		BeanUtils.copyProperties(userDtoObjRes, returnValue);
		return returnValue;
	}
	
	@DeleteMapping
	public String deleteMapping()
	{
		return "this is delete mapping";
	}
	
	@PutMapping
	public String putMapping()
	{
		return "This is put mapping";
	}
}
