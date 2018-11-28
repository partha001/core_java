package com.partha.hashCodeAndEquals;

import com.partha.hashCodeAndEquals.model.Book;

public class Application02 {
	
	  public static void main( String[] args )
	    {
//		  String s="test";
//		  Book book1=new Book(1,s);
//		  System.out.println(s.hashCode()+" "+book1.hashCode());
//		//  Book book2=new Book(1,"book1");
//		  
//		 s="hello world";
//		 
//		 System.out.println(s.hashCode()+" "+book1.hashCode());
//		 book1.setBookname("test2");
//		  
//		  //System.out.println(book1.equals(book2));
//		  System.out.println(book1.hashCode());
//		  book1.setBookname("abc");
//		  System.out.println(book1.hashCode());
		 
		  Emp emp1=new Emp();
		  System.out.println(emp1.hashCode());
		  emp1.setId(1);
		  emp1.setName("partha");
		  System.out.println(emp1.hashCode());
		  emp1.setId(2);
		  emp1.setName("animesh");
		  System.out.println(emp1.hashCode());
		  
	    }
}
