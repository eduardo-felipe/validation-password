package br.com.iti.validationpassword.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.iti.validationpassword.controller.ValidationPasswordController;
import br.com.iti.validationpassword.dto.ValidationPasswordRequest;

@WebMvcTest(ValidationPasswordController.class)
class ValidationPasswordIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void whenPasswordIsValidThenReturnSuccess() throws Exception {
		String password = "12345678aA@";
		ValidationPasswordRequest validationPasswordRequest = ValidationPasswordRequest.builder().password(password)
			.build();

		ObjectMapper mapper = new ObjectMapper();
		String requestJson = mapper.writeValueAsString(validationPasswordRequest);
		
		this.mockMvc
			.perform(MockMvcRequestBuilders.post("/password/validates")
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(requestJson))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().json("{'isValidPassword': true}"));
	}

	@Test
	void whenPasswordIsValidThenReturnUnsuccess() throws Exception {
		String password = "12345678aA";
		ValidationPasswordRequest validationPasswordRequest = ValidationPasswordRequest.builder().password(password)
			.build();

		ObjectMapper mapper = new ObjectMapper();
		String requestJson = mapper.writeValueAsString(validationPasswordRequest);
		
		this.mockMvc
			.perform(MockMvcRequestBuilders.post("/password/validates")
			.contentType(MediaType.APPLICATION_JSON_VALUE)			
			.content(requestJson))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().json("{'isValidPassword': false, 'message' : 'A senha deve conter ao menos um caracter especial.'}"));
	}
	
	@Test
	void whenPasswordLessNineCharacteresThenReturnUnsuccessful() throws Exception {
		String password = "5478989";
		ValidationPasswordRequest validationPasswordRequest = ValidationPasswordRequest.builder().password(password)
				.build();

			ObjectMapper mapper = new ObjectMapper();
			String requestJson = mapper.writeValueAsString(validationPasswordRequest);
			
			this.mockMvc
				.perform(MockMvcRequestBuilders.post("/password/validates")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{'isValidPassword': false, 'message' : 'A senha deve conter nove ou mais caracteres.'}"));
	}
	
	@Test
	void whenPasswordHasNotOneDigitThenReturnUnsuccessful() throws Exception {
		String password = "asdfghjkkle";
		ValidationPasswordRequest validationPasswordRequest = ValidationPasswordRequest.builder().password(password)
				.build();

			ObjectMapper mapper = new ObjectMapper();
			String requestJson = mapper.writeValueAsString(validationPasswordRequest);
			
			this.mockMvc
				.perform(MockMvcRequestBuilders.post("/password/validates")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{'isValidPassword': false, 'message' : 'A senha deve conter ao menos um número.'}"));
	}
	
	@Test
	void whenPasswordHasNotOneLowerCaseThenReturnUnsuccessful() throws Exception {
		String password = "ASDFGHJK123@";
		ValidationPasswordRequest validationPasswordRequest = ValidationPasswordRequest.builder().password(password)
				.build();

			ObjectMapper mapper = new ObjectMapper();
			String requestJson = mapper.writeValueAsString(validationPasswordRequest);
			
			this.mockMvc
				.perform(MockMvcRequestBuilders.post("/password/validates")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{'isValidPassword': false, 'message' : 'A senha deve conter ao menos uma letra minuscula.'}"));
	}
	
	@Test
	void whenPasswordHasNotOneUpperCaseThenReturnUnsuccessful() throws Exception {
		String password = "asdfghjkl1@";
		ValidationPasswordRequest validationPasswordRequest = ValidationPasswordRequest.builder().password(password)
				.build();

			ObjectMapper mapper = new ObjectMapper();
			String requestJson = mapper.writeValueAsString(validationPasswordRequest);
			
			this.mockMvc
				.perform(MockMvcRequestBuilders.post("/password/validates")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{'isValidPassword': false, 'message' : 'A senha deve conter ao menos uma letra maiuscula.'}"));
	}
	
	@Test
	void whenPasswordHasNotOneSpecialCharacterThenReturnUnsuccessful() throws Exception {
		String password = "asdfghjkl1A";
		ValidationPasswordRequest validationPasswordRequest = ValidationPasswordRequest.builder().password(password)
				.build();

			ObjectMapper mapper = new ObjectMapper();
			String requestJson = mapper.writeValueAsString(validationPasswordRequest);
			
			this.mockMvc
				.perform(MockMvcRequestBuilders.post("/password/validates")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{'isValidPassword': false, 'message' : 'A senha deve conter ao menos um caracter especial.'}"));
	}
	
	@Test
	void whenPasswordHasSpacesThenReturnUnsuccessful() throws Exception {
		String password = "asdfg hjklA1@";
		ValidationPasswordRequest validationPasswordRequest = ValidationPasswordRequest.builder().password(password)
				.build();

			ObjectMapper mapper = new ObjectMapper();
			String requestJson = mapper.writeValueAsString(validationPasswordRequest);
			
			this.mockMvc
				.perform(MockMvcRequestBuilders.post("/password/validates")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{'isValidPassword': false, 'message' : 'A senha não deve conter espaços.'}"));
	}
	
	@Test
	void whenPasswordHasRepeatedCharactersThenReturnUnsuccessful() throws Exception {
		String password = "asdfgghjklA1@";
		ValidationPasswordRequest validationPasswordRequest = ValidationPasswordRequest.builder().password(password)
				.build();

			ObjectMapper mapper = new ObjectMapper();
			String requestJson = mapper.writeValueAsString(validationPasswordRequest);
			
			this.mockMvc
				.perform(MockMvcRequestBuilders.post("/password/validates")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{'isValidPassword': false, 'message' : 'A senha não deve conter caracteres repetidos.'}"));
	}	
}
