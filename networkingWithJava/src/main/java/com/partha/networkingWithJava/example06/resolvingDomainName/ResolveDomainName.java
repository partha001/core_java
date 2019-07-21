package com.partha.networkingWithJava.example06.resolvingDomainName;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ResolveDomainName {

	public static void main(String[] args) {
		BufferedReader  input = new BufferedReader(new InputStreamReader(System.in));
		input.lines().forEach( (line) -> {
			InetAddress address;
			try {
				address = InetAddress.getByName(line);
				System.out.println(address.getHostAddress());
			} catch (UnknownHostException e) {
				System.out.println("unknown host");
			}
		});
	}

}
