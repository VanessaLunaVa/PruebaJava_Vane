package com.zs.franquicia.services.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.zs.franquicia.dto.LoginUserDto;
import com.zs.franquicia.entity.UserEntity;
import com.zs.franquicia.repository.UserRepository;
import com.zs.franquicia.services.JwtService;
import com.zs.franquicia.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;

	@Override
	public UserEntity authenticate(LoginUserDto input) throws Exception {
		try {
			UserEntity user = userRepository.findByUsername(input.getEmail()).orElseThrow();
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
			String jwtToken = jwtService.generateToken(user);
			user.setToken(jwtToken);
			userRepository.save(user);
			user.setExpirationTime(jwtService.getExpirationTime());
			return user;
		} catch (NoSuchElementException e) {
			throw new BadCredentialsException(e.getMessage());
		}

	}

}
