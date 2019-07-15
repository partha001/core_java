package com.partha.networkingWithJava.example04.readingFromUrl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ReadingFromUrlUsingSocket {

	public static void main(String[] args) {
		try{
			Socket socket = new Socket("www.packtpub.com",80);
			OutputStream os = socket.getOutputStream();
			os.write(("GET / HTTP/1.1\r\n"+
						"Host: www.packtpub.com\r\n\r\n").getBytes());
			os.flush();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line;
			while((line = reader.readLine())!=null){
				System.out.println(line);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
