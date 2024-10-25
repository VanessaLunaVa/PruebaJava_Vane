
package com.zs.franquicia.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.franquicia.dto.SucursalDto;
import com.zs.franquicia.entity.FranquiciaEntity;
import com.zs.franquicia.entity.SucursalEntity;
import com.zs.franquicia.repository.SucursalRepository;
import com.zs.franquicia.services.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService {
	
	@Autowired
	private SucursalRepository sucursalRepository;

	@Override
	public SucursalEntity saveSucursal(SucursalDto input) {
		SucursalEntity e = new SucursalEntity();
		e.setNombre(input.getNombre());
		e.setFranquiciaEntity(new FranquiciaEntity(input.getIdFranquicia()));
		return sucursalRepository.save(e);
	}
	

}
