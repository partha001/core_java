package com.partha.designPatterns.solid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * this program shows the problem if we dont follow liskov substitution principle
 * @author biswaspa
 *
 */
public class LiskovSubstituionPriciple2 {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(10, 20);
		Square square = new Square(10);

		testRectangle(rectangle);
		testSquare(square);
	}


	//test rectangle
	private static void testRectangle(Rectangle rectangle) {
		rectangle.setHeight(10);
		rectangle.setWidth(20);
		System.out.println("" +(rectangle.getHeight()==10) + "       " +(rectangle.getWidth()==20));	
	}
	
	//test square
	private static void testSquare(Square square) {
		square.setSide(100);
		square.setSide(10);
		System.out.println(square.getSide()==100);
	}


	static interface Shape {
		
		int computeArea();
		
	}

	@Getter
	@Setter
	@AllArgsConstructor
	static class Rectangle implements Shape {
		private int height;
		private int width;
		
		@Override
		public int computeArea() {
			return this.height*this.width;
		}
	}

	@Getter
	@Setter
	@AllArgsConstructor
	static class Square implements Shape{
		
		int side;

		@Override
		public int computeArea() {
			return this.side*this.side;
		}		
	}
}

