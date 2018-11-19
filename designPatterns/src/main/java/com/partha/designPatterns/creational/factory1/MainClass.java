package com.partha.designPatterns.creational.factory1;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IceCream icecream_obj1;
				
        IcecreamFactory icecreamFactory=new IcecreamFactory();
        /* notice that watever string i pass to the below method 
         * at runtime makes the icecream make factory decide the 
         * type of icecream that is to be make at runtime  */
        icecream_obj1=icecreamFactory.makeIcecream("vanilla");
        showDetails(icecream_obj1);
		
	}

	public static void showDetails(IceCream iceCream){
		iceCream.showName();
		iceCream.showPrice();
	}


}
