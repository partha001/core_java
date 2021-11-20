package com.partha.problemSolving.strings;

/**
 * this is not complete
 * @author parbiswa
 *
 */
public class ReversingString {

	public static void main(String[] args) {
//		Scanner scanner= new Scanner(System.in);
//		System.out.println("enter some text");
//		String s= scanner.nextLine();
		
		String s="partha biswas";
		System.out.println(""+reversedString(s));
	}

	public static String reversedString(String s){
		if(s.length()<2 ){
			return s;
		}else{
			char[] charArray = s.toCharArray();
			char[] result=new char[charArray.length];
			for(int i=charArray.length-1;i>=0;i--){
				result[result.length-1-i]=charArray[i];
			}
			return "";
		}

	}
	
	
	

}
