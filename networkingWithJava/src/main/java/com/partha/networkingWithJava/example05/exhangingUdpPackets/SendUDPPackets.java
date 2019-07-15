package com.partha.networkingWithJava.example05.exhangingUdpPackets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SendUDPPackets {
	
	private static final String MESSAGE = "HELLO WORLD";

	public static void main(String[] args) {
		try {
			byte[] buffer = MESSAGE.getBytes();
			InetAddress address = InetAddress.getLocalHost();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length , address , 1024);
			DatagramSocket datagramSocket = new DatagramSocket();
			datagramSocket.send(packet);
			System.out.println("SENT: "+MESSAGE);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
