package com.viksuu.techie.transactionalmanagement.usercreation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viksuu.techie.transactionalmanagement.model.User;


public interface UserRepository extends JpaRepository<User,Integer> {

}
