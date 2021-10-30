package br.com.lab.impacta.account.handler;

import java.util.Date;

import lombok.Getter;

@Getter
public class ErroMessageReponse {

	private int statusCode;
	private Date timestamp;
	private String message;
	private String description;

	public ErroMessageReponse(int statusCode, Date timestamp, String message, String description) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}

}
