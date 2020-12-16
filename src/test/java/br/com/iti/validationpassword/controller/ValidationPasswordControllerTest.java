package br.com.iti.validationpassword.controller;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.iti.validationpassword.dto.ValidationPasswordRequest;
import br.com.iti.validationpassword.exception.PasswordInvalidException;
import br.com.iti.validationpassword.service.ValidationPasswordService;

@WebMvcTest
class ValidationPasswordControllerTest {

	@Autowired
	private MockMvc mockMvc;

	
	@MockBean 
	private ValidationPasswordService validationPasswordService;
	 

	@Test
	void whenPasswordIsValidThenReturnControllerSuccess() throws Exception {
		String password = "12345678aA@";
		ValidationPasswordRequest validationPasswordRequest = ValidationPasswordRequest.builder().password(password)
			.build();

		ObjectMapper mapper = new ObjectMapper();
		String requestJson = mapper.writeValueAsString(validationPasswordRequest);
		
		BDDMockito.given(validationPasswordService.validatePassword(password)).willReturn(true);
		
		this.mockMvc
			.perform(MockMvcRequestBuilders.post("/validation/validate")
			.contentType("application/json")
			.content(requestJson))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().json("{'isValidPassword': true}"));
	}

	@Test
	void whenPasswordIsValidThenReturnControllerUnsuccess() throws Exception {
		String password = "12345678aA";
		ValidationPasswordRequest validationPasswordRequest = ValidationPasswordRequest.builder().password(password)
			.build();

		ObjectMapper mapper = new ObjectMapper();
		String requestJson = mapper.writeValueAsString(validationPasswordRequest);

		BDDMockito.given(validationPasswordService.validatePassword(password))
			.willThrow(new PasswordInvalidException("A senha deve conter ao menos um caracter especial."));
		
		this.mockMvc
			.perform(MockMvcRequestBuilders.post("/validation/validate")
			.contentType("application/json")
			.content(requestJson))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().json("{'isValidPassword': false, 'message' : 'A senha deve conter ao menos um caracter especial.'}"));
	}
}
