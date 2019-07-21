package com.partha.networkingWithJava.example07.udpEchoServer;

public class PortsUsed {
	
	//this is the port on which the server listens to incoming connections
	public static final int SERVER_PORT = 1024;
	
	//the port on which the client listens to incoming connections
	//thus without this the packet will just be lost we wont be able to understand 
	//whether the echo server is at all echoing or not
	public static final int CLIENT_PORT = 1025;
}
