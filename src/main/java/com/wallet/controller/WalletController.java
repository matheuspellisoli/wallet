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

import com.wallet.dto.WalletDTO;
import com.wallet.entity.Wallet;
import com.wallet.response.Response;
import com.wallet.service.WalletService;
import com.wallet.util.Convert;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	WalletService service;

	@PostMapping
	public ResponseEntity<Response<WalletDTO>> create(@Valid @RequestBody WalletDTO dto, BindingResult result) {
		Response<WalletDTO> response = new Response<WalletDTO>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(r -> response.getErrors().add(r.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Wallet wallet = (Wallet) Convert.convertDtoToEntity(dto, new Wallet());
		response.setData(Convert.convertEntityToDto(new WalletDTO(), service.save(wallet)));

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}