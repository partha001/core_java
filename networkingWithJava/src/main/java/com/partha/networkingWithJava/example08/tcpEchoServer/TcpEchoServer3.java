package com.partha.networkingWithJava.example08.tcpEchoServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * multiclient echo-server with executor-service
 * @author partha
 *
 */
public class TcpEchoServer3 {

	private static final int TELNET_PORT = 23;
	private static final int BUFFER_LENGTH = 1024;
	
	public static void main(String[] args) {

		try {

			ServerSocket socket = new ServerSocket(TcpEchoServer3.TELNET_PORT);
			ExecutorService executor = Executors.newFixedThreadPool(3);


			while(true) {

				Socket clientSocket = socket.accept();
				InetSocketAddress remote  =  (InetSocketAddress) clientSocket.getRemoteSocketAddress();
				System.out.println("connection from port="+remote.getPort()+ "  host="+remote.getHostName());
				executor.submit(

						() -> {
							InputStream in = null ;
							try {
								in = clientSocket.getInputStream();
								OutputStream out = clientSocket.getOutputStream();
								byte[] buffer = new byte[BUFFER_LENGTH];
								while(clientSocket.isConnected()) {
									int len = in.read(buffer);
									if(len>0) {
										out.write(buffer,0,len);
									}
								}
							} catch (IOException e) {
								e.printStackTrace();
							}

						}

						);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
