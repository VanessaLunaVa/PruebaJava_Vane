package com.zs.franquicia.services;

import com.zs.franquicia.dto.LoginUserDto;
import com.zs.franquicia.entity.UserEntity;

public interface LoginService {

	UserEntity authenticate(LoginUserDto loginUserDto) throws Exception;

}
