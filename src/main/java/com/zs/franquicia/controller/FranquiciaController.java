package com.zs.franquicia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.franquicia.dto.FranquiciaDto;
import com.zs.franquicia.dto.ResponseJson;
import com.zs.franquicia.entity.FranquiciaEntity;
import com.zs.franquicia.services.FranquiciaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RequestMapping("/franquicia")
@RestController
public class FranquiciaController {

	@Autowired
	private FranquiciaService franquiciaService;

	@Operation(description = "Crear franquicia", responses = {
			@ApiResponse(responseCode = "200", description = "Franquicia creada correctamente", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject(value = "{\"message\" : \"OK\", \"response\" : {\"id\" : \"1\",  \"nombre\" : \"NOMBRE_FRANQUICIA\" } }"), })) })
	@PostMapping("/create")
	public ResponseEntity<ResponseJson> createFranquicia(@Valid @RequestBody FranquiciaDto franquiciaDto) throws Exception {
		ResponseJson body = new ResponseJson();
		FranquiciaEntity franquicia = franquiciaService.saveFranquicia(franquiciaDto);
		body.setMensaje(HttpStatus.OK.getReasonPhrase());
		body.setResponse(franquicia);
		return ResponseEntity.ok(body);
	}

}
