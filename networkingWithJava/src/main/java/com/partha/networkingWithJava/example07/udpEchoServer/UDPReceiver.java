package com.partha.networkingWithJava.example07.udpEchoServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * this is a reuable class which is used by both the server and the client to receive 
 * incoming message
 * @author partha
 *
 */
public class UDPReceiver {

	private static final int BUFLEN = 2000;
	final private int port;
	DatagramPacket receivePacket ;
	private DatagramSocket serverSocket = null;

	UDPReceiver(int port) { 
		this.port = port ;
	}
	
	boolean isBound(){
		return serverSocket != null && serverSocket.isBound();
	}
	
	String receive(){
		try{
			Thread.sleep(1000);
			serverSocket = new DatagramSocket(port);
			byte[] receiveData = new byte[BUFLEN];
			receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			return new String(receivePacket.getData());
		}
		catch(Exception ex){
			return ex.toString();
		}
	}

}
