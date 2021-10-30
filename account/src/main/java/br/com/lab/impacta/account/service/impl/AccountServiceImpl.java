package br.com.lab.impacta.account.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.lab.impacta.account.handler.exception.AccountDontExistsException;
import br.com.lab.impacta.account.handler.exception.AccountWithoutBalanceException;
import br.com.lab.impacta.account.model.Account;
import br.com.lab.impacta.account.repository.AccountRepository;
import br.com.lab.impacta.account.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;

	@Value("${lab.account.exceptions.account-dont-exists-message}")
	private String messageExceptionAccountDontExists;

	@Value("${lab.account.exceptions.account-dont-exists-description}")
	private String messageExceptionAccountDontExistsDescription;

	@Value("${lab.account.exceptions.account-without-balance-message}")
	private String messageExceptionAccountWithoudBalanceMessage;

	@Value("${lab.account.exceptions.account-without-balance-description}")
	private String accountWithoutBalanceDescription;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public Account findAccount(Long accountId) {
		Optional<Account> accountOpt = accountRepository.findById(accountId);

		if (accountOpt.isEmpty()) {
			throw new AccountDontExistsException(messageExceptionAccountDontExists,
					messageExceptionAccountDontExistsDescription);
		}

		return accountOpt.get();

	}

	@Override
	public void debitAccount(Long accountId, Double valueOfDebit) {
		Account account = this.findAccount(accountId);

		boolean debited = account.debit(valueOfDebit);

		if (!debited) {
			throw new AccountWithoutBalanceException(messageExceptionAccountWithoudBalanceMessage,
					accountWithoutBalanceDescription);
		}

		accountRepository.save(account);

	}

}
