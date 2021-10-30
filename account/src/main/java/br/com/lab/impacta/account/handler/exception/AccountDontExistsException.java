package br.com.lab.impacta.account.handler.exception;

import lombok.Getter;

@Getter
public class AccountDontExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String description;

	public AccountDontExistsException(String description) {
		super();
		this.description = description;
	}

	public AccountDontExistsException(String message, String description) {
		super(message);
		this.description = description;
	}
}
