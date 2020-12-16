package br.com.iti.validationpassword.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.iti.validationpassword.exception.PasswordInvalidException;

class ValidationPasswordServiceTest {

	private static ValidationPasswordService validationPasswordService;
	
	@BeforeAll
	static void setupTest() {
		validationPasswordService = new ValidationPasswordService();
	}
	
	@Test
	void whenPasswordLessNineCharacteresThenReturnException() {
		String password = "5478989";
		
		Throwable exception = Assertions.assertThrows(PasswordInvalidException.class, () -> validationPasswordService.validatePasswordMinimumCharacters(password));
		
		Assertions.assertEquals("A senha deve conter nove ou mais caracteres.", exception.getMessage());
	}
	
	@Test
	void whenPasswordGreaterNineCharacteresThenReturnSuccess() {
		String password = "54789899999988";
		
		Assertions.assertDoesNotThrow(() -> validationPasswordService.validatePasswordMinimumCharacters(password));
		
	}
	
	@Test
	void whenPasswordHasNotOneDigitThenReturnException() {
		String password = "asdfghjkkle";
		
		Throwable exception = Assertions.assertThrows(PasswordInvalidException.class, () -> validationPasswordService.validatePasswordAtLeastOneDigit(password));
		
		Assertions.assertEquals("A senha deve conter ao menos um número.", exception.getMessage());
	}
	
	@Test
	void whenPasswordHasOneDigitThenReturnSuccess() {
		String password = "dfghjkl1tyy";
		
		Assertions.assertDoesNotThrow(() -> validationPasswordService.validatePasswordAtLeastOneDigit(password));
		
	}
	
	
	@Test
	void whenPasswordHasNotOneLowerCaseThenReturnException() {
		String password = "ASDFGHJKLJKFGH";
		
		Throwable exception = Assertions.assertThrows(PasswordInvalidException.class, () -> validationPasswordService.validatePasswordAtLeastOneLowerCase(password));
		
		Assertions.assertEquals("A senha deve conter ao menos uma letra minuscula.", exception.getMessage());
	}
	
	@Test
	void whenPasswordHasOneLowerCaseThenReturnSuccess() {
		String password = "ASDFGHJKLa";
		
		Assertions.assertDoesNotThrow(() -> validationPasswordService.validatePasswordAtLeastOneLowerCase(password));
		
	}
	
	@Test
	void whenPasswordHasNotOneUpperCaseThenReturnException() {
		String password = "asdfghjkl";
		
		Throwable exception = Assertions.assertThrows(PasswordInvalidException.class, () -> validationPasswordService.validatePasswordAtLeastOneUpperCase(password));
		
		Assertions.assertEquals("A senha deve conter ao menos uma letra maiuscula.", exception.getMessage());
	}
	
	@Test
	void whenPasswordHasOneUpperCaseThenReturnSuccess() {
		String password = "asdfghjklA";
		
		Assertions.assertDoesNotThrow(() -> validationPasswordService.validatePasswordAtLeastOneUpperCase(password));
		
	}
	
	@Test
	void whenPasswordHasNotOneSpecialCharacterThenReturnException() {
		String password = "asdfghjkl";
		
		Throwable exception = Assertions.assertThrows(PasswordInvalidException.class, () -> validationPasswordService.validatePasswordAtLeastOneSpecialCharacter(password));
		
		Assertions.assertEquals("A senha deve conter ao menos um caracter especial.", exception.getMessage());
	}
	
	@Test
	void whenPasswordHasOneSpecialCharacterThenReturnSuccess() {
		String password = "asdfghjklA@";
		
		Assertions.assertDoesNotThrow(() -> validationPasswordService.validatePasswordAtLeastOneSpecialCharacter(password));
		
	}
	
	@Test
	void whenPasswordHasSpacesThenReturnException() {
		String password = "asdfg hjkl";
		
		Throwable exception = Assertions.assertThrows(PasswordInvalidException.class, () -> validationPasswordService.validatePasswordWithoutSpaces(password));
		
		Assertions.assertEquals("A senha não deve conter espaços.", exception.getMessage());
	}
	
	@Test
	void whenPasswordHasNoSpacesThenReturnSuccess() {
		String password = "asdfghjklA@";
		
		Assertions.assertDoesNotThrow(() -> validationPasswordService.validatePasswordWithoutSpaces(password));
		
	}
	
	@Test
	void whenPasswordHasRepeatedCharactersThenReturnException() {
		String password = "asdfgghjkl";
		
		Throwable exception = Assertions.assertThrows(PasswordInvalidException.class, () -> validationPasswordService.validatePasswordWithRepeatedCharacters(password));
		
		Assertions.assertEquals("A senha não deve conter caracteres repetidos.", exception.getMessage());
	}
	
	@Test
	void whenPasswordHasNotRepeatedCharactersThenReturnSuccess() {
		String password = "asdfghjklA@";
		
		Assertions.assertDoesNotThrow(() -> validationPasswordService.validatePasswordWithRepeatedCharacters(password));
		
	}
	
	@Test
	void whenPasswordIsValidThenReturnIsTrue() {
		String password = "Asdf1ghj@kl";
		
		boolean isValid = validationPasswordService.validatePassword(password);
		
		Assertions.assertTrue(isValid);
	}
	
	@Test
	void whenPasswordIsNotValidThenReturnIsFalse() {
		String password = "AAsdf1ghj@kl";

		Throwable exception = Assertions.assertThrows(PasswordInvalidException.class, () -> validationPasswordService.validatePassword(password));

		Assertions.assertEquals("A senha não deve conter caracteres repetidos.", exception.getMessage());
	}
}
