package com.partha.networkingWithJava.example09.filteringClients01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * problemStatement : the intension of this program is to allow only those ip addresses which matches 
 * with a regular expression mentioned in my properties file.
 * 
 * it also denies client connections which match denied ip address regular expression mentioned in the 
 * properties file
 * @author partha
 *
 */
public class FilteringClients {

	private static final int TELNET_PORT =23;

	private static final int BUFFER_LENGTH =1024;

	private static Config config = new ConfigReader().getConfig();

	public static void main(String[] args) throws IOException {		
		final ServerSocket serverSocket = new ServerSocket(TELNET_PORT);
		final ExecutorService service = Executors.newFixedThreadPool(3);
		while(true){
			final Socket clientSocket = serverSocket.accept();
			final InetSocketAddress remote = (InetSocketAddress) clientSocket.getRemoteSocketAddress();
			final InetAddress address = remote.getAddress();
			final String hostAddress = address.getHostAddress();
			System.out.println("connection from port="+ remote.getPort() + " ip="+ hostAddress);
			if(isAllowed(hostAddress)){
				serve(service, clientSocket);
			} else {
				clientSocket.close();
				System.out.println("connection from port="+ remote.getPort() + " ip="+ hostAddress + " is refused");
			}
		}

	}

	private static boolean isAllowed(String hostAddress){
		return config.getAllowedIps()
				.stream()
				.anyMatch(hostAddress::matches)
				&&
				config.getDeniedIps()
				.stream()
				.noneMatch(hostAddress::matches);
	}

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