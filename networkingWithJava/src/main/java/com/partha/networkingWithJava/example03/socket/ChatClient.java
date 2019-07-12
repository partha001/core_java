package com.partha.networkingWithJava.example03.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

	public static void main(String[] args) {
		try{
			String username = args[0];
			Socket socket = new Socket("127.0.0.1", 8080);
			System.out.println(socket.hashCode());
			Thread sender  =  new Thread(new Sender(socket, username));
			Thread receiver  =  new Thread(new Receiver(socket, username));
			sender.start();
			receiver.start();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


	static class Sender implements Runnable{

		private Socket socket;
		private String username;


		public Sender(Socket socket, String username) {
			super();
			this.socket = socket;
			this.username = username;
		}

		public void run() {
			try{
				System.out.println("this is sender console for username :"+ this.username);
				
				//this is for reading data from keyboard entered by the user
				BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			
				//creating a printWriter to send data to the server
				PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
				
				while(true){
					String s = userInput.readLine();
					pr.println(this.username+" : "+s);
				}
				
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

	}


	static class Receiver implements Runnable{

		private Socket socket;
		private String username;

		public Receiver(Socket socket, String username) {
			super();
			this.socket = socket;
			this.username = username;
		}


		public void run() {
			try{
				System.out.println("this is receiver console for username :"+ this.username);
				
				BufferedReader socketInput = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				while(true){
					String messageReceived = socketInput.readLine();
					System.out.println(messageReceived);
				}

			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

	}


}




