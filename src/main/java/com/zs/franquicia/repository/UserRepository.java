package com.zs.franquicia.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zs.franquicia.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
	
	UserEntity findByUsernameAndPassword(String userName, String password);

	Optional<UserEntity> findByUsername(String username);

}
