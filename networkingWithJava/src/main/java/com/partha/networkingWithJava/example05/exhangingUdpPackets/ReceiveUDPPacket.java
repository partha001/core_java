package com.partha.networkingWithJava.example05.exhangingUdpPackets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveUDPPacket {
	
	private static final int BUFLEN = 2000;

	public static void main(String[] args) {
		DatagramSocket serverSocket;
		try {
			serverSocket = new DatagramSocket(1024);
			byte[] receiveData = new byte[BUFLEN];
			
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String (receivePacket.getData());
			System.out.println("RECEIVED :"+ sentence);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
