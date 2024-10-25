package com.zs.franquicia.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Getter
@lombok.Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginUserDto {
	
	private String name;
	@NotNull(message = "Debe ingresar un correo")
	private String email;
	@NotNull(message = "Debe ingresar la contraseña")
	private String password;
	

}
