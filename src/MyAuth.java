package io;

import javax.mail.PasswordAuthentication;

public class MyAuth extends javax.mail.Authenticator {

	protected PasswordAuthentication getPasswordAuthentication() {
		//Scanner TakeInput = new Scanner(System.in);
		LetMail acess =  new LetMail();
		String UserName = acess.YourEmail;
		String UserPassword = acess.YourPassword;
		acess=null;
		return new PasswordAuthentication(UserName,UserPassword);
	}

	
}
