package com.viksuu.techie.transactionalmanagement.usercreation.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.viksuu.techie.transactionalmanagement.model.Mail;
import com.viksuu.techie.transactionalmanagement.usercreation.repository.MailRepository;

@Service
public class SendEmail {

	@Autowired
	private MailRepository repo;

//	@Transactional
	public String sendMail(String emailId)  {

		String response;
		/*try {
			if (emailId.contains("@") && emailId.contains(".") && emailId.length() >= 8) {

					Mail mail = new Mail();
					mail.setEmailId(emailId);
					mail.setSubject("Congratulation");
					mail.setMailBody("Thank You for Connecting with us...");
					repo.save(mail);
					response = "Mail sent to user...";
			} else {
				
				response = "failed";
				throw new Exception();
			}

		} catch (Exception e) {
			System.out.println("Invalid Email Address");
			response = "failed";

		}*/
		
		
		if (emailId.contains("@") && emailId.contains(".") && emailId.length() >= 8) {
			//valid email address
			Mail mail = new Mail();
			//failing the condition....
//			mail.setEmailId(emailId+"asdfasdfasdlkfjasdljflasdjflkasjdfasdf");
			mail.setEmailId("emailId");
			
			mail.setSubject("Congratulation");
			mail.setMailBody("Thank You for Connecting with us...");
			repo.save(mail);
			response = "Mail sent to user...";
	} 
		else response =  "failed";
		
		return response;

	}
}
