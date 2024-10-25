package com.zs.franquicia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.franquicia.dto.ResponseJson;
import com.zs.franquicia.dto.SucursalDto;
import com.zs.franquicia.services.SucursalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RequestMapping("/sucursal")
@RestController
public class SucursalController {

	@Autowired
	private SucursalService sucursalService;

	@Operation(description = "Crear Sucursal", responses = {
			@ApiResponse(responseCode = "200", description = "Sucursal creada correctamente", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject(value = "{\"message\" : \"OK\", \"response\" : {\"id\" : \"1\",  \"nombre\" : \"NOMBRE_FRANQUICIA\" } }"), })) })
	@PostMapping("/create")
	public ResponseEntity<ResponseJson> createSucursal(@Valid @RequestBody SucursalDto sucursalDto) throws Exception {
		ResponseJson body = new ResponseJson();
		sucursalService.saveSucursal(sucursalDto);
		body.setMensaje(HttpStatus.OK.getReasonPhrase());
		body.setResponse("Sucursal creada correctamente");
		return ResponseEntity.ok(body);
	}

}
