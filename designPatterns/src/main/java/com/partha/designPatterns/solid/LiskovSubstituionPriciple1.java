package com.partha.designPatterns.solid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * this is a solution to the above problem. thus here we code the above problem following 
 * liskov-substituion priciple
 * @author biswaspa
 *
 */
public class LiskovSubstituionPriciple1 {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(10, 20);
		Square square = new Square(10);
		
		testRectangle(rectangle);
		testRectangle(square);
	}
	
	
	//1.let this be a test method rectangle
	//2.it is to be noted that square is child class of rectangle 
	//	but it the methods yields diffenent output 
	//	or exhibits different behavior
	//	this is violation of liskov substitution priciple.
	private static void testRectangle(Rectangle rectangle) {
		rectangle.setHeight(10);
		rectangle.setWidth(20);
		System.out.println("" +(rectangle.getHeight()==10) + "       " +(rectangle.getWidth()==20));	
	}
	
	
	
	@Getter
	@Setter
	@AllArgsConstructor
	static class Rectangle {
		private int height;
		private int width;
	}

	static class Square extends Rectangle{
		
		public Square(int side) {
			super(side, side);
		}
		
		@Override
		public void setHeight(int height) {
			setSide(height);
		}

		@Override
		public void setWidth(int width) {
			setSide(width);
		}
		
		public void setSide(int side) {
			super.setHeight(side);
			super.setWidth(side);
		}
	}
}




