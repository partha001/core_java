package com.partha.coreJava.hashcodeNequals.example01;


/**
 * this is to verify that == operator doesnt do a hashcode comparison
 * @author partha
 *
 */
public class Application01 {

	public static void main(String[] args) {

		String s1="FB";
		String s2="Ea";
		System.out.println("s1-hashcode="+s1.hashCode()+"   s2-hashcode="+s2.hashCode());
		System.out.println(s1==s2);
	}

}
