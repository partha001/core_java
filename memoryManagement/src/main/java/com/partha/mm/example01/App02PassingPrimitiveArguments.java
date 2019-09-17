package com.partha.mm.example01;

/**
 * this program shows how primitive values are passed
 * thus primitive values are always passed by values
 * @author partha
 *
 */
public class App02PassingPrimitiveArguments {

	public static void main(String[] args) {
		int var = 10;
		changeValue(var);
		System.out.println(var);
	}
	
	//thus when this method is called the suppied value is copied to var
	public static void changeValue(int var){
		var = var+1;
	}

}
