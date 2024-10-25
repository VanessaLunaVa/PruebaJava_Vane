
package com.zs.franquicia.services.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zs.franquicia.dto.RegisterUserDto;
import com.zs.franquicia.entity.UserEntity;
import com.zs.franquicia.repository.UserRepository;
import com.zs.franquicia.services.JwtService;
import com.zs.franquicia.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Value("${app.config.expPass}")
	private String exprePass;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@Override
	public UserEntity saveUser(RegisterUserDto input) throws Exception {
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(exprePass);
		java.util.regex.Matcher matcher = pattern.matcher(input.getPassword());
		if (userRepository.findByUsername(input.getEmail()).isPresent()) {
			throw new BadRequestException("El correo ya existe");
		}
		if (!matcher.matches()) {
			throw new BadRequestException("La constraseña no cumple con el formato");
		} else {

			

			UUID uuid = UUID.randomUUID();
			UserEntity user = UserEntity.builder().uuid(uuid.toString()).created(new Date()).isactive("S")
					.lastLogin(new Date()).modified(new Date()).username(input.getEmail()).name(input.getName())
					.password(passwordEncoder.encode(input.getPassword())).token("").build();
			userRepository.save(user);
			Optional<UserEntity> findById = userRepository.findById(uuid.toString());
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));

			String jwtToken = jwtService.generateToken(findById.get());
			findById.get().setToken(jwtToken);
			return userRepository.save(findById.get());
		}
	}

}
