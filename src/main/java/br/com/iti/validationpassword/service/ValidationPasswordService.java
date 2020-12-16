package br.com.iti.validationpassword.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.iti.validationpassword.exception.PasswordInvalidException;

@Service
public class ValidationPasswordService {

	public boolean validatePassword(final String password) {
		try {
			validatePasswordMinimumCharacters(password);
			validatePasswordAtLeastOneDigit(password);
			validatePasswordAtLeastOneLowerCase(password);
			validatePasswordAtLeastOneUpperCase(password);
			validatePasswordAtLeastOneSpecialCharacter(password);
			validatePasswordWithoutSpaces(password);
			validatePasswordWithRepeatedCharacters(password);
			
			return true;
		} catch(Exception exception) {
			throw new PasswordInvalidException(exception.getMessage());		
		}
	}


	protected void validatePasswordMinimumCharacters(final String password) {
		if (password.length() < 9) {
			throw new PasswordInvalidException("A senha deve conter nove ou mais caracteres.");		
		}
	}

	protected void validatePasswordAtLeastOneDigit(final String password) {
		if (!password.matches(".*\\d+.*")) {
			throw new PasswordInvalidException("A senha deve conter ao menos um número.");		
		}
	}

	protected void validatePasswordAtLeastOneLowerCase(final String password) {
		if (!password.matches(".*[a-z].*")) {
			throw new PasswordInvalidException("A senha deve conter ao menos uma letra minuscula.");		
		}
	}

	protected void validatePasswordAtLeastOneUpperCase(final String password) {
		if (!password.matches(".*[A-Z].*")) {
			throw new PasswordInvalidException("A senha deve conter ao menos uma letra maiuscula.");		
		}
	}

	protected void validatePasswordAtLeastOneSpecialCharacter(final String password) {
		if (!password.matches(".*[!@#$%^&*(-/].*")) {
			throw new PasswordInvalidException("A senha deve conter ao menos um caracter especial.");		
		}
	}

	protected void validatePasswordWithoutSpaces(final String password) {
		if (password.contains(" ")) {
			throw new PasswordInvalidException("A senha não deve conter espaços.");		
		}
	}

	protected void validatePasswordWithRepeatedCharacters(final String password) {
		List<Character> duplicateCaracteres = new ArrayList<>();
		char[] passwordArray = password.toCharArray();

		for (char caracter : passwordArray) {
			if (duplicateCaracteres.contains(caracter)) {
				throw new PasswordInvalidException("A senha não deve conter caracteres repetidos.");
			}

			duplicateCaracteres.add(caracter);
		}
	}
}
