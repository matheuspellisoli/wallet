package com.wallet.response;

import java.util.ArrayList;
import java.util.List;

import com.wallet.dto.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {
	
	private DTO data;
	private List<String> errors;
		
	public List<String> getErrors() {
		if(errors == null)
			errors = new ArrayList<String>();
		return  errors;
	}
}
