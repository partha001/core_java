package com.partha.designPatterns.behavioral.visitor1;

public interface ShoppingCartVisitor {
	
	int visit(Book book);
	int visit(Fruit fruit);

}
