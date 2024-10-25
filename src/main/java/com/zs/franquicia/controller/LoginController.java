package com.zs.franquicia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.franquicia.dto.LoginResponse;
import com.zs.franquicia.dto.LoginUserDto;
import com.zs.franquicia.dto.ResponseJson;
import com.zs.franquicia.entity.UserEntity;
import com.zs.franquicia.services.LoginService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RequestMapping("/auth")
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Operation(summary = "Autenticar un usuario")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Successful") })
	@PostMapping("/login")
	public ResponseEntity<Object> authenticate(@Valid @RequestBody LoginUserDto loginUserDto) {
		ResponseJson body = new ResponseJson();

		UserEntity authenticatedUser;
		try {
			authenticatedUser = loginService.authenticate(loginUserDto);

			LoginResponse loginResponse = LoginResponse.builder().token(authenticatedUser.getToken())
					.expiresIn(authenticatedUser.getExpirationTime()).build();

			body.setMensaje(HttpStatus.OK.getReasonPhrase());
			body.setResponse(loginResponse);
			return ResponseEntity.ok(body);

		} catch (BadCredentialsException e) {
			e.printStackTrace();
			body.setMensaje("Email o contraseña erroneo");
			return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			e.printStackTrace();
			body.setMensaje("Ah ocurrido un error en la aplicación, por favor comuniquese con el Administrador.");
			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
