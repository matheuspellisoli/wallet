package com.wallet.dto;

import javax.validation.constraints.NotNull;

import com.wallet.entity.User;
import com.wallet.entity.Wallet;

import lombok.Data;

@Data
public class UserWalletDTO implements DTO {
	
	private Long id;
	@NotNull(message = "Informe o id do usuário")
	private Long users;
	@NotNull(message = "Informe o id do carteira")
	private Long wallet;
	
}
