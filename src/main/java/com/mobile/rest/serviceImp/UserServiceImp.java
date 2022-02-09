package com.mobile.rest.serviceImp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.rest.DAO.UserRepository;
import com.mobile.rest.Utils.UtilForUserid;
import com.mobile.rest.dto.UserDto;
import com.mobile.rest.entity.UserEntity;
import com.mobile.rest.service.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	UtilForUserid userid;
	
	@Override
	public UserDto createUser(UserDto userDtoObj) {
		
		if(userrepo.findByEmail(userDtoObj.getEmail())!=null)throw new RuntimeException("user already Exists in database");
		UserEntity user=new UserEntity();
		
		BeanUtils.copyProperties(userDtoObj, user);
		
		user.setEncryptedPassword("test");
		user.setUserId(userid.generate(30));
		UserEntity resp=userrepo.save(user);
		
		UserDto responce=new UserDto();
		BeanUtils.copyProperties(resp, responce);
		
		return responce;
	}

}
