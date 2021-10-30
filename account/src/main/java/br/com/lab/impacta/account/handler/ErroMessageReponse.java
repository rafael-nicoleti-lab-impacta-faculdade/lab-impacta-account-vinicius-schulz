package br.com.lab.impacta.account.handler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroMessageReponse {

	private int statusCode;
	private Date timestamp;
	private String message;
	private String description;

}
