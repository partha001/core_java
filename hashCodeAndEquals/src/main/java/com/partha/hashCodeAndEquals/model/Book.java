package com.partha.hashCodeAndEquals.model;

public class Book {
	
	private int bookid;
	private String bookname;
	
	
	
	public Book(int bookid, String bookname) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
	}
	
	

	public int getBookid() {
		return bookid;
	}



	public void setBookid(int bookid) {
		this.bookid = bookid;
	}



	public String getBookname() {
		return bookname;
	}



	public void setBookname(String bookname) {
		this.bookname = bookname;
	}



	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + bookid;
//		result = prime * result + ((bookname == null) ? 0 : bookname.hashCode());
//		return result;
		return bookname.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Book other = (Book) obj;
//		if (bookid != other.bookid)
//			return false;
//		if (bookname == null) {
//			if (other.bookname != null)
//				return false;
//		} else if (!bookname.equals(other.bookname))
//			return false;
//		return true;
		return (this.bookname.equals(((Book)obj).bookname));
	}
	
	

}
