package com.partha.networkingWithJava.example02.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",8080);
			System.out.println("socket created");
			
			//this is for reading data from keyboard entered by the user
			BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
			
			//creating another buffered reader to read from the socket input stream
			BufferedReader input2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//creating a printWriter to send data to the server
			PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
			
			
			int option = 0;
			int number1 = 0;
			int number2 = 0;
			
			boolean flag = true;
			
			while(true){
				
				System.out.println("enter 1 for addition");
				System.out.println("enter 2 for subtraction");
				System.out.println("enter 3 for multiplication");
				System.out.println("enter 4 for division");
				System.out.println("enter 5 for exit");
				
				System.out.println("enter option");
				option = Integer.parseInt(input1.readLine());
				
				if(option==5){
					break;
				}
				
				System.out.println("enter an number1");
				number1 = Integer.parseInt(input1.readLine());
				
				System.out.println("enter an number2");
				number2 = Integer.parseInt(input1.readLine());
				
				pr.println(option);
				pr.println(number1);
				pr.println(number2);
				
				System.out.println("result =" + input2.readLine());
				
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
