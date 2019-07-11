package com.partha.networkingWithJava.example02.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		try {
			//creatin the server socket
			ServerSocket ss  = new ServerSocket(8080);
			System.out.println("waiting for client");
			Socket socket = ss.accept();
			
			//declaring a reading to read from client 
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//declaring a output stream write to write to the client 
			//passing the second argument as true so that we dont have to flush explicitly , rather send the message instantaneously
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			System.out.println("client connection established successfully");
			
			
			while(true){
				int operation = Integer.parseInt(in.readLine());
				int num1 = Integer.parseInt(in.readLine());
				int num2 = Integer.parseInt(in.readLine());
				int result =0;
				switch(operation){
				case(1) : result = num1 + num2; break;
				case(2) : result = num1 - num2; break;
				case(3) : result = num1 * num2; break;
				case(4) : result = num1 / num2; break;
				}
				System.out.println("result:"+ result);
				
			}
			
					
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
