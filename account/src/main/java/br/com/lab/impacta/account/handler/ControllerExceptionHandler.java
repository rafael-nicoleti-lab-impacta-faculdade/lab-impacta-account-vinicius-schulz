package br.com.lab.impacta.account.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lab.impacta.account.handler.exception.AccountDontExistsException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(AccountDontExistsException.class)
	public ResponseEntity<ErroMessageReponse> accountNotFoundException(
			AccountDontExistsException accountDontExistsException) {

		ErroMessageReponse erroMessageReponse = new ErroMessageReponse(HttpStatus.NOT_FOUND.value(), new Date(),
				accountDontExistsException.getMessage(), accountDontExistsException.getDescription());

		return new ResponseEntity<>(erroMessageReponse, HttpStatus.NOT_FOUND);

	}

}
