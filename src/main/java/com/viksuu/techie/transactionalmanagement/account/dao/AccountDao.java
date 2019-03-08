package com.viksuu.techie.transactionalmanagement.account.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.viksuu.techie.transactionalmanagement.model.Account;

@Component
public class AccountDao {

	@Autowired
	private AccountOperation operation;
	
	@Transactional
	public void transferMoney(Account to, Account from, int amount) throws Exception {
		operation.debitFromAccount(from, amount);
		operation.creditToAccount(to, amount);

	}

}
/*
 * @Transactional only rolls back transactions for unchecked exceptions. For
 * checked exceptions and their subclasses, it commits data. So although an
 * exception is raised here,because it's a checked exception, Spring ignores it
 * and commits the data to the database, making the system inconsistent.
 */
/*
 * It's
 * 
 * very simple, just use the following with @Transactional:
 * 
 * @Transactional(rollbackFor = Exception.class) So if you throw an Exception or
 * a subclass of it, always use the above with the
 * 
 * @Transactional annotation to tell Spring to roll back transactions if a
 * checked exception occurs.
 */