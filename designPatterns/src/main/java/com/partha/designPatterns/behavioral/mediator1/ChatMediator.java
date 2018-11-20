package com.partha.designPatterns.behavioral.mediator1;

public interface ChatMediator {
	
	public void sendMessage(String msg, User user);

	void addUser(User user);

}
