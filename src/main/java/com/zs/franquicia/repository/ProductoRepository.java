package com.zs.franquicia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zs.franquicia.entity.ProductoEntity;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoEntity, Long> {
	
	@Query("SELECT p FROM ProductoEntity p WHERE (p.cantidad, p.sucursalEntity.id) in (SELECT  MAX(p.cantidad), p.sucursalEntity.id  FROM ProductoEntity p WHERE p.sucursalEntity.franquiciaEntity.id =:idFranquicia GROUP BY p.sucursalEntity)")
	List<ProductoEntity> lstProductosMayorCantidad(@Param("idFranquicia") Long idFranquicia);

}
