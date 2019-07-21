package com.partha.networkingWithJava.example09.filteringClients02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * problemStatement : the intension of this program is to allow only 
 * @author partha
 *
 */
public class FilteringClients {

	private static final int TELNET_PORT =23;

	private static final int BUFFER_LENGTH =1024;

	//here first we mention an ip-address of type ipv4 and the second is of type ipv6
	private static final String[] allowedIps = {"127.0.0.2","::2"};
	
	
	
	public static void main(String[] args) throws IOException {		
		final ServerSocket serverSocket = new ServerSocket(TELNET_PORT);
		final ExecutorService service = Executors.newFixedThreadPool(3);
		while(true){
			final Socket clientSocket = serverSocket.accept();
			final InetSocketAddress remote = (InetSocketAddress) clientSocket.getRemoteSocketAddress();
			final InetAddress address = remote.getAddress();
			final byte[] ip = address.getAddress();
			System.out.println("connection from port="+ remote.getPort() + " ip="+ Arrays.toString(ip));
			if(isAllowed(ip)){
				serve(service, clientSocket);
			} else {
				clientSocket.close();
				System.out.println("connection from port="+ remote.getPort() + " ip="+ Arrays.toString(ip) + " is refused");
			}
		}

	}
	
	private static boolean isAllowed(byte[] ip){
		return allowedAddresses
				.stream()
				.map(InetAddress::getAddress)
				.anyMatch(allowed -> Arrays.equals(ip, allowed));
	}
	
	final static Collection<InetAddress> allowedAddresses =
			Arrays.stream(allowedIps)
					.map(t -> {
						InetAddress address = null;
						try {
							 address = InetAddress.getByName(t);
						} catch (UnknownHostException e) {
							e.printStackTrace();
						}
						return address;
					})
					.collect(Collectors.toSet());

	

	private static void serve(ExecutorService service,Socket clientSocket){
		service.submit(

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

}
