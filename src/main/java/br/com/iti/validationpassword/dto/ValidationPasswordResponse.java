package br.com.iti.validationpassword.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ValidationPasswordResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("isValidPassword")
	private boolean validPassword;
	
	@JsonProperty("message")
	@JsonInclude(Include.NON_NULL)
	private String message;
	
}
