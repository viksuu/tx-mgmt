package com.viksuu.techie.transactionalmanagement.account.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.viksuu.techie.transactionalmanagement.account.service.AccountTransactionService;
import com.viksuu.techie.transactionalmanagement.model.Account;

@RestController
public class AccountResources {

	Account to;
	Account from;
	List<Account> bank;

	@Autowired
	private AccountTransactionService service;

	@GetMapping("/balance/{accountNo}")
	public int getBalance(@PathVariable int accountNo) {

		return 0;
	}

	@PostConstruct
	public void feed() {
		bank = new ArrayList<Account>();
		to = new Account(1, "Vikash", 500);
		from = new Account(2, "Garv", 1000);
		bank.add(to);
		bank.add(from);
	}

	@GetMapping("/do")
	public void doOperation() throws Exception {
		int transfer_amount = 100;

		service.makeTransaction(to, from, transfer_amount);

	}

/*	@PutMapping("/change/{id}")
	public boolean doSomething(@PathVariable("id") int accountHolder_id, @RequestBody Account account) {

		for (Account accountSearch : bank) {
			if (accountSearch.getId() == accountHolder_id) {
				accountSearch.setAccount_holder_name(account.getAccount_holder_name());
				accountSearch.setBalance(account.getBalance());
			}
		}

		bank.forEach(e-> System.out.println(e));
		return true;
	}
*/
}
