package com.partha.designPatterns.behavioral.visitor1;

public interface ItemElement {
	
	public int accept(ShoppingCartVisitor visitor);

}
