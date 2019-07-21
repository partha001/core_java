package com.partha.networkingWithJava.example08.tcpEchoServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * this is example of a single client echo server
 * @author partha
 *
 */
public class TcpEchoServer {

	private static final int TELNET_PORT = 8081;
	private static final int BUFFER_LENGTH = 1024;
	
	public static void main(String[] args) {
		
		try {
			ServerSocket socket = new ServerSocket(TcpEchoServer.TELNET_PORT);
			Socket clientSocket = socket.accept();
			InetSocketAddress remote  =  (InetSocketAddress) clientSocket.getRemoteSocketAddress();
			System.out.println("connection from port="+remote.getPort()+ "  host="+remote.getHostName());
			InputStream in = clientSocket.getInputStream();
			OutputStream out = clientSocket.getOutputStream();
			byte[] buffer = new byte[BUFFER_LENGTH];
			while(clientSocket.isConnected()) {
				int len = in.read(buffer);
				if(len>0) {
					out.write(buffer,0,len);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
