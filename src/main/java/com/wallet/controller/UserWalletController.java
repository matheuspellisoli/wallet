

package com.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.UserWalletDTO;
import com.wallet.entity.User;
import com.wallet.entity.UserWallet;
import com.wallet.entity.Wallet;
import com.wallet.response.Response;
import com.wallet.service.UserWalletService;
import com.wallet.util.Convert;

@RestController
@RequestMapping("/userwallet")
public class UserWalletController {

	@Autowired
	UserWalletService service;

	@PostMapping
	public ResponseEntity<Response<UserWalletDTO>> create(@Valid @RequestBody UserWalletDTO dto, BindingResult result) {
		Response<UserWalletDTO> response = new Response<UserWalletDTO>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(r -> response.getErrors().add(r.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(convertEntityToDto(service.save(convertDtoToEntity(dto))));

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private UserWallet convertDtoToEntity (UserWalletDTO dto) {
		UserWallet userWallet = new UserWallet();
		User user = new User();
		user.setId(dto.getUsers());
		Wallet wallet = new Wallet();
		wallet.setId(dto.getWallet());
		
		userWallet.setId(dto.getId());
		userWallet.setUsers(user);
		userWallet.setWallet(wallet);
		
		return userWallet;
	}
	
	
	private UserWalletDTO convertEntityToDto (UserWallet userWallet) {
		UserWalletDTO dto = new UserWalletDTO();
		dto.setId(userWallet.getId());
		dto.setUsers(userWallet.getUsers().getId());
		dto.setWallet(userWallet.getWallet().getId());
		return dto;
	}
}


