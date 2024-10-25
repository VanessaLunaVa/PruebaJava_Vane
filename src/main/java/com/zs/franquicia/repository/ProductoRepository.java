package com.zs.franquicia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zs.franquicia.dto.ProductoResponse;
import com.zs.franquicia.entity.ProductoEntity;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoEntity, Long> {
	
	@Query("SELECT new com.zs.franquicia.dto.ProductoResponse( p.id, p.nombre, MAX(p.cantidad) as cantidad,   p.sucursalEntity.id, p.sucursalEntity.nombre) FROM ProductoEntity p WHERE p.sucursalEntity.franquiciaEntity.id =:idFranquicia GROUP BY p.sucursalEntity")
	List<ProductoResponse> lstProductosMayorCantidad(@Param("idFranquicia") Long idFranquicia);

}
