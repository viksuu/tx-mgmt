package com.viksuu.techie.transactionalmanagement.account.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.viksuu.techie.transactionalmanagement.account.repository.AccountRepository;
import com.viksuu.techie.transactionalmanagement.model.Account;

@Component
public class AccountOperation {
	
	
	@Autowired
	private AccountRepository repo;

	@Transactional
	public void debitFromAccount(Account from, int amount) {
		System.out.println("From " + from.getAccount_holder_name() + "balance : " + from.getBalance()
				+ " amount to deduct " + amount);
		from.setBalance(from.getBalance() - amount);
		Account acc = repo.save(from);
		System.out.println(acc);

	}
	

	@Transactional(rollbackFor = Exception.class)
	public void creditToAccount(Account to, int amount) throws Exception {

		System.out.println(
				"To " + to.getAccount_holder_name() + " balance : " + to.getBalance() + " amount to credit " + amount);
		to.setBalance(to.getBalance() + amount);
		Account acc = repo.save(to);
		System.out.println(acc);
		throw new Exception("Error during credit");
	}


}
