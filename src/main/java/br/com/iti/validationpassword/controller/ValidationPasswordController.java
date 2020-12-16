package br.com.iti.validationpassword.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iti.validationpassword.dto.ValidationPasswordRequest;
import br.com.iti.validationpassword.dto.ValidationPasswordResponse;
import br.com.iti.validationpassword.service.ValidationPasswordService;

@RestController
@RequestMapping("/validation")
public class ValidationPasswordController {

	private ValidationPasswordService validationPasswordService;
	
	public ValidationPasswordController(ValidationPasswordService validationPasswordService) {
		this.validationPasswordService = validationPasswordService;
	}
	
	@PostMapping("/validate")
	public ValidationPasswordResponse validatePassword(@RequestBody ValidationPasswordRequest request) {	
		try {	 
			return ValidationPasswordResponse.builder()
				.validPassword(validationPasswordService.validatePassword(request.getPassword()))
				.build();
		} catch(Exception exception) {
			return ValidationPasswordResponse.builder()
				.validPassword(false)
				.message(exception.getMessage())
				.build();	
		}
	}
	
}