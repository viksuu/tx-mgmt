package com.viksuu.techie.transactionalmanagement.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viksuu.techie.transactionalmanagement.account.dao.AccountDao;
import com.viksuu.techie.transactionalmanagement.model.Account;

@Service
public class AccountTransactionService {
	
	@Autowired
	private AccountDao dao;
	
	public String makeTransaction(Account to, Account from, int amount) throws Exception{
		
		dao.transferMoney(to, from, amount);
		return "To :: " +to+ " and From ::" + from;
	}

}
