package com.zs.franquicia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Getter
@lombok.Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SucursalDto {

	private String nombre;
	private Long idFranquicia;

}
