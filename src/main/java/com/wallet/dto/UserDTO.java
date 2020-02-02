package com.wallet.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements DTO{
	
	private Long id;
	
	@NotNull
	private String name;
	
	@Email(message = "Email inválido")
	private String email;
	
	@NotNull()
	@Length(min = 6, message = "Senha deve conter no mínimo 6 caracteres")
	private String password;
}
