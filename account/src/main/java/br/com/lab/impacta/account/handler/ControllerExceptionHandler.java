package br.com.lab.impacta.account.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lab.impacta.account.handler.exception.AccountDontExistsException;
import br.com.lab.impacta.account.handler.exception.AccountWithoutBalanceException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(AccountDontExistsException.class)
	public ResponseEntity<ErroMessageReponse> accountNotFoundException(
			AccountDontExistsException accountDontExistsException) {

		ErroMessageReponse erroMessageReponse = new ErroMessageReponse(HttpStatus.NOT_FOUND.value(), new Date(),
				accountDontExistsException.getMessage(), accountDontExistsException.getDescription());

		return new ResponseEntity<>(erroMessageReponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(AccountWithoutBalanceException.class)
	public ResponseEntity<ErroMessageReponse> withoutBalanceException(
			AccountWithoutBalanceException accountWithoutBalanceException) {

		ErroMessageReponse erroMessageReponse = new ErroMessageReponse(HttpStatus.BAD_REQUEST.value(), new Date(),
				accountWithoutBalanceException.getMessage(), accountWithoutBalanceException.getDescription());

		return new ResponseEntity<>(erroMessageReponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErroMessageReponse> genericException(RuntimeException runtimeException) {

		ErroMessageReponse erroMessageReponse = new ErroMessageReponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				new Date(), runtimeException.getMessage(), "");

		return new ResponseEntity<>(erroMessageReponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
