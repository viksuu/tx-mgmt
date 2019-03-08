package com.viksuu.techie.transactionalmanagement.usercreation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viksuu.techie.transactionalmanagement.model.Mail;


public interface MailRepository extends JpaRepository<Mail,Integer> {

}
