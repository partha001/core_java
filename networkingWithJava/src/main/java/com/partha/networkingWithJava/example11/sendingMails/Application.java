package com.partha.networkingWithJava.example11.sendingMails;


/**
 * though the program is correct and gives us an idea about how mail sending
 * works however this doesnt work because recent security related changes done by google
 * @author partha
 *
 */
public class Application {
	

	public static void main(String[] args) {
		final String from = "biswas.partha1@gmail.com";
		final String to = from;
		final String password ="xxx$";
		
		MailSender.sendMail(from,to,password);
		System.out.println("messaage sent");
	}

}
