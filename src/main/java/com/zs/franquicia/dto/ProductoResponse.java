package com.zs.franquicia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Getter
@lombok.Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoResponse {

	private Long id;
	private String nombreP;
	private Long cantidad;
	private Long idSucursal;
	private String nombreSucursal;
}
