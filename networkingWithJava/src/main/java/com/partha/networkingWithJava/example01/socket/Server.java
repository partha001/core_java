package com.partha.networkingWithJava.example01.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			
			//creating the server socket
			ServerSocket ss = new ServerSocket(8080);
			System.out.println("waiting for client");
			
			//the program comes and waits at this line to accept a client to connect
			Socket accept = ss.accept();
			System.out.println("connection with client established");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
