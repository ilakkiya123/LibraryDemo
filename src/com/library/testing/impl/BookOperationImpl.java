package com.library.testing.impl;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import com.library.testing.Book;
import com.library.testing.BookOperation;

public abstract class BookOperationImpl extends Book implements BookOperation {

	//Here extends is important because from main method we can directly create object for child class from here we can call super() to intialize the objects 
	public BookOperationImpl() {
		super("","",true);
	}

	public BookOperationImpl(String book_name, String author, boolean bool) {
		super(book_name, author, bool);
		
	}
	
	//Here return_Date is an object of LocalDate
	public void returnBook(List<Book> bookcollection, LocalDate return_date, String book_name) {
		Scanner scan = new Scanner(System.in);
		long daysCount = 0;
		//to get the current date 
		LocalDate currentDate = LocalDate.now();
		
		//Here returning date is already passed current date so checking if it is before current date meaning - from the return till current date is the date lagged in returning the book 
		if(return_date.isBefore(currentDate)) {
			daysCount = ChronoUnit.DAYS.between(return_date ,currentDate);
			double penalty_amt = penalty(daysCount);
			
			System.out.println("Your due by: " + daysCount + " .Pls pay the penalty amount: " + penalty_amt);
		}
		else if(return_date.isEqual(currentDate)){
			System.out.println("Your On Time .Please Visit the Library Again");
		}else {
			System.out.println("Great !! You Submitted the Book Before Return Date.Please Visit the Library Again");
		}
	}

	private double penalty(long daysCount) {
		System.out.println("Penalty for each day is $1.5 ");
		return daysCount * 1.5;
	}
	
	public void findReturnBook(List<Book> bookcollection, String book_name, Scanner scan) {
		int count = 0 ;
		for(Book b : bookcollection) {
			String trimmed_book_name = book_name.trim();
			if(b.getBook_name().equalsIgnoreCase(trimmed_book_name)){
				b.setAvailable(true);
				count ++ ;
				break ;
			}
		}
		if(count == 0) {
			System.out.println("Please check the spelling ...");
		}
		
	}
	public void BorrowBook(List<Book> bookcollection, String book_name) {
		for(Book b : bookcollection) {
			String trimmed_book_name = book_name.trim();
			if(b.getBook_name().equalsIgnoreCase(trimmed_book_name)){
				b.setAvailable(false);
				break ;
			}
		}
		System.out.println("Your Book is succesfully borrowed ");
	}
}

