package com.zs.franquicia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zs.franquicia.dto.ProductoDto;
import com.zs.franquicia.dto.ProductoResponse;
import com.zs.franquicia.dto.ResponseJson;
import com.zs.franquicia.services.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RequestMapping("/producto")
@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@Operation(description = "Crear Sucursal", responses = {
			@ApiResponse(responseCode = "200", description = "Producto creado correctamente", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject(value = "{\"message\" : \"OK\", \"response\" : {\"id\" : \"1\",  \"nombre\" : \"NOMBRE_PRODUCTO\" } }"), })) })
	@PostMapping("/create")
	public ResponseEntity<ResponseJson> createSucursal(@Valid @RequestBody ProductoDto productoDto) throws Exception {
		ResponseJson body = new ResponseJson();
		productoService.saveProducto(productoDto);
		body.setMensaje(HttpStatus.OK.getReasonPhrase());
		body.setResponse("Producto creada correctamente");
		return ResponseEntity.ok(body);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED) // 201
	public ResponseEntity<ResponseJson> actualizar(@RequestBody ProductoDto productoDto, @PathVariable Long id) {
		ResponseJson body = new ResponseJson();
		productoService.editarProducto(productoDto, id);
		body.setMensaje(HttpStatus.OK.getReasonPhrase());
		body.setResponse("Producto actualizado correctamente");
		return ResponseEntity.ok(body);
	}
	
	@GetMapping("/{idFranquicia}")
	public ResponseEntity<ResponseJson> listarProductos(@PathVariable Long idFranquicia) throws Exception {
		ResponseJson body = new ResponseJson();
		List<ProductoResponse> list = productoService.getList(idFranquicia);
		body.setMensaje(HttpStatus.OK.getReasonPhrase());
		body.setResponse(list);
		return ResponseEntity.ok(body);
		
	}

		
	

}
