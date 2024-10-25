package com.zs.franquicia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zs.franquicia.entity.SucursalEntity;

@Repository
public interface SucursalRepository extends CrudRepository<SucursalEntity, Long> {
	
	

}
