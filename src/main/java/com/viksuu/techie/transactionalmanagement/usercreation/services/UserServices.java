package com.viksuu.techie.transactionalmanagement.usercreation.services;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.viksuu.techie.transactionalmanagement.model.Mail;
import com.viksuu.techie.transactionalmanagement.model.User;
import com.viksuu.techie.transactionalmanagement.usercreation.repository.MailRepository;
import com.viksuu.techie.transactionalmanagement.usercreation.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private MailRepository mailRepo;

	@Autowired
	private SendEmail mailService;

//	@Transactional(value = TxType.)
	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED)
	public User createUser(User user) {

		User u = null;
//		user.setName("afasfasfasdfsdfasdfasdf");
		String emailId = user.getEmail();
		u = userRepo.save(user);
		
		
		// send mail
		if (emailId.contains("@") && emailId.contains(".") && emailId.length() >= 8) {
			// valid email address
			Mail mail = new Mail();
			mail.setEmailId("asdfasdfsdafasdfasdfffdfdafdsfadfasdfasdfasdf");
			mail.setSubject("Congratulation");
			mail.setMailBody("Thank You for Connecting with us...");
			mailRepo.save(mail);
//			response = "Mail sent to user...";
		}
		System.out.println("Sending mail" + mailService.sendMail(user.getEmail()));
//		u = saveUser(user);
		System.out.println("User created...");
		return u;

	}

	private User saveUser(User user) {
		User u;
		u = userRepo.save(user);
		return u;
	}

}

// failing mail validation
//user.setEmail(user.getEmail().replace("@",""));
