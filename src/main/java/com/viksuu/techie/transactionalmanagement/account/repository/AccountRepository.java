package com.viksuu.techie.transactionalmanagement.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viksuu.techie.transactionalmanagement.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>{

}
