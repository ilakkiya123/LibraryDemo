package com.library.testing;

import java.util.List;

public class Book {
	protected String book_name ;
	protected String author ;
	protected boolean available ;
	protected int return_date ;
	
	public Book(String book_name , String author , boolean available) {		
		this.book_name = book_name;
		this.author= author;
		this.available = available ;
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
	}



	public String getBook_name() {
		return book_name;
	}


	public String getAuthor() {
		return author;
	}

	
	public boolean getAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}


	public int getReturn_date() {
		return return_date;
	}


	public void setReturn_date(int return_date) {
		this.return_date = return_date;
	}
	
	@Override
	public String toString() {
		return "Book [book_name=" + book_name + ", author=" + author + ", available=" + available + ", return_date="
				+ return_date + "]";
	}

}
