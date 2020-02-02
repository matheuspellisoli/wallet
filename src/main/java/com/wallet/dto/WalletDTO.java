package com.wallet.dto;


import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class WalletDTO implements DTO{
		
	private Long id;
	
	@Length(min = 3, message = "O nome deve ter mais de 3 caracteres")
	@NotNull(message = "O nome não pode ser nulo")
	private String name;
	
	@NotNull(message = "Insira um valor para a carteira")
	private BigDecimal value;

}
