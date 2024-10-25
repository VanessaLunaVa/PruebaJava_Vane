package com.zs.franquicia.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Getter
@lombok.Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserDto {
	
	
	
	@NotNull(message = "Debe ingresar un nombre")
	private String name;
	@NotNull(message = "Debe ingresar un correo")
	@Pattern(message = "El correo no cumple con el formato", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	private String email;
	@NotNull(message = "Debe ingresar un password")
	private String password;
	@NotNull(message = "Debe ingresar al menos un telefono")
	private List<SucursalDto> phones;

}
