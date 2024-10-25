package com.zs.franquicia.services;

import java.util.List;

import com.zs.franquicia.dto.ProductoDto;
import com.zs.franquicia.dto.ProductoResponse;
import com.zs.franquicia.entity.ProductoEntity;

public interface ProductoService {

	ProductoEntity saveProducto(ProductoDto dto);
	
	ProductoEntity editarProducto(ProductoDto dto, Long id);
	
	List<ProductoResponse> getList(Long idFranquicia);
}
