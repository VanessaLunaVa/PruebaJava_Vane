package com.zs.franquicia.services;

import com.zs.franquicia.dto.RegisterUserDto;
import com.zs.franquicia.entity.UserEntity;

public interface UserService {

	UserEntity saveUser(RegisterUserDto input) throws Exception;
	
}
