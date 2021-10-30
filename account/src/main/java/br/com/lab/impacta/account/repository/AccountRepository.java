package br.com.lab.impacta.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lab.impacta.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
