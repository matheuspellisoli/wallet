package com.wallet.util;

import org.modelmapper.ModelMapper;

import com.wallet.dto.DTO;
import com.wallet.entity.Entity;

public class Convert{
	
	public static Entity convertDtoToEntity(DTO dto, Entity entity) {		
		return new ModelMapper().map(dto, entity.getClass());
	}
	
	public static DTO convertEntityToDto(DTO dto, Entity entity) {
		return new ModelMapper().map(entity, dto.getClass());
	}
}
