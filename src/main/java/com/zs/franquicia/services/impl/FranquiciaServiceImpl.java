
package com.zs.franquicia.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.franquicia.dto.FranquiciaDto;
import com.zs.franquicia.entity.FranquiciaEntity;
import com.zs.franquicia.repository.FranquiciaRepository;
import com.zs.franquicia.services.FranquiciaService;

@Service
public class FranquiciaServiceImpl implements FranquiciaService {
	
	@Autowired
	private FranquiciaRepository franquiciaRepository;

	@Override
	public FranquiciaEntity saveFranquicia(FranquiciaDto input)  {
		return franquiciaRepository.save(new FranquiciaEntity(input.getNombre()));
	}
	

}
