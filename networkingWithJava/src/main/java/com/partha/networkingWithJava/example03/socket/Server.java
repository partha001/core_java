package com.partha.networkingWithJava.example03.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {


	public static List<Socket> socketList = new ArrayList<Socket>();

	public static void main(String[] args) {
		int i=1;
		try{

			ServerSocket serverSocket = new ServerSocket(8080);
			while(true){
				Socket socket = serverSocket.accept();
				socketList.add(socket);
				System.out.println("client connection established successfully :"+ socket.hashCode());
				Thread thread = new Thread(new ChatThread(socket, i++));
				thread.start();
			}


		}catch(Exception ex){
			ex.printStackTrace();
		}
	}



	public static void storeMessage(String message,Socket senderSocket){
		try{
//			String sendername = map.get(senderSocket);
			for(Socket socket : socketList){
				if(socket!=senderSocket){
					PrintWriter socketOutput = new PrintWriter(socket.getOutputStream(),true);
					socketOutput.println(message);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


	static  class ChatThread implements Runnable{

		private Socket socket;
		private Integer threadId;


		public ChatThread(Socket socket,Integer threadId) {
			super();
			this.socket = socket;
			this.threadId = threadId;
		}



		public void run() {

			try{

				BufferedReader socketInput = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

				while(true){
					String message = socketInput.readLine();
					Server.storeMessage(message,this.socket);
				}

			}
			catch(Exception ex){
				ex.printStackTrace();
			}

		}

	}


}
