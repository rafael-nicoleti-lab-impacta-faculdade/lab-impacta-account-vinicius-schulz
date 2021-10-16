package br.com.lab.impacta.account.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long number;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Person person;

	private Double balance;

	public boolean debit(Double valueDebit) {
		if (this.getBalance() < valueDebit) {
			return false;
		}

		Double debitedAmount = this.getBalance() - valueDebit;
		setBalance(debitedAmount);

		return true;

	}

}
