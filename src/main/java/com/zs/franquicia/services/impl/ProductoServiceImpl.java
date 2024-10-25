
package com.zs.franquicia.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.franquicia.dto.ProductoDto;
import com.zs.franquicia.dto.ProductoResponse;
import com.zs.franquicia.entity.ProductoEntity;
import com.zs.franquicia.entity.SucursalEntity;
import com.zs.franquicia.repository.ProductoRepository;
import com.zs.franquicia.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public ProductoEntity saveProducto(ProductoDto input) {
		ProductoEntity entity = ProductoEntity.builder().id(input.getId()).cantidad(input.getCantidad())
				.nombre(input.getNombre()).sucursalEntity(new SucursalEntity(input.getIdSucursal())).build();
		return productoRepository.save(entity);
	}

	@Override
	public ProductoEntity editarProducto(ProductoDto dto, Long id) {
		Optional<ProductoEntity> findById = productoRepository.findById(id);
		if (findById.isPresent()) {
			findById.get().setCantidad(dto.getCantidad());
			if (dto.getNombre() != null && !dto.getNombre().isEmpty()) {
				findById.get().setNombre(dto.getNombre());
			}
			return productoRepository.save(findById.get());
		} else {
			return null;
		}
	}

	@Override
	public List<ProductoResponse> getList(Long idFranquicia) {
		List<ProductoResponse> r = new ArrayList<ProductoResponse>();
		List<ProductoEntity> lstProductosMayorCantidad = productoRepository.lstProductosMayorCantidad(idFranquicia);
		lstProductosMayorCantidad.forEach(p -> {
			ProductoResponse pp = ProductoResponse.builder().cantidad(p.getCantidad()).id(p.getId())
					.nombreProducto(p.getNombre()).idSucursal(p.getSucursalEntity().getId())
					.nombreSucursal(p.getSucursalEntity().getNombre()).build();
			r.add(pp);
		});
		return r;
	}

}
