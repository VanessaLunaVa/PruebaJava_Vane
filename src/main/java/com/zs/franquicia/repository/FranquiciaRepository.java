package com.zs.franquicia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zs.franquicia.entity.FranquiciaEntity;

@Repository
public interface FranquiciaRepository extends CrudRepository<FranquiciaEntity, Long> {
	
	

}
