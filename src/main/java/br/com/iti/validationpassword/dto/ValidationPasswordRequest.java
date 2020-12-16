package br.com.iti.validationpassword.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidationPasswordRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String password;
	
}
