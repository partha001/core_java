package com.partha.mm.example01;

/**
 * this example shows that primitive values are always pass by value
 * @author parbiswa
 *
 */
public class Application01 {

	public static void main(String[] args) {
		int var = 10;
		incrementByOneHundred(var);
		System.out.println(var);
		
	}
	
	public static void incrementByOneHundred(int var){
		var =  var + 100;
	}
	
	//some comment
	//comment2 made on master branch

}
