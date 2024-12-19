package com.library.testing;
import com.library.testing.impl.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class BookCollection{
	
	public static void main(String args[]) {
		List<Book> bookcollection = new ArrayList<>();
		initializebookcollection(bookcollection);
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println();
			System.out.println("Enter your need in our library(Please Enter a number)" + "\n" + "1.find Book " + "\n" + "2.Return Book" + "\n" + "3.Borrow Book" + "\n"+ "4.List of All Books with availability" + "\n" +"5.Exit");
			int input = scan.nextInt();
			scan.nextLine();
			if(input == 5) {
				System.out.println("Thank you for visiting library");
				break ;
			}
			else {
				try {
					selectOption(input , scan , bookcollection);
				}catch(NumberFormatException e) {
					System.out.println(e);
				}
			}
		}
		scan.close();
	}
	
	public static void initializebookcollection(List<Book> bookcollection) {
		bookcollection.add(new Book("Ponniyin Selvan-1" , "Kalki" , true));
		bookcollection.add(new Book("Ponniyin Selvan-2" , "Kalki" , true));
		bookcollection.add(new Book("Ponniyin Selvan-3" , "Kalki" , true));
		bookcollection.add(new Book("Ponniyin Selvan-4" , "Kalki" , true));
		bookcollection.add(new Book("Ponniyin Selvan-5" , "Kalki" , true));
		bookcollection.add(new Book("Atomic Habits" , "James Clear" , true));
		bookcollection.add(new Book("Wings Of Fire" , "Abdul kalam" , true));
		bookcollection.add(new Book("Money Master The Game" , "Anthony Robbins" , true));
		bookcollection.add(new Book("The Psychology Of Money" , "Morgan Housel" , true));
		bookcollection.add(new Book("The 7 Habits of Highly Effective People" , "R.Stephen Covey" , true));
	}
	
	public static void selectOption(int option , Scanner scan , List<Book> bookcollection) {

		BookOperationImpl bookimpl = new FindBookOperationImpl();
		
		String book_name ;
			switch(option) {
			case 1:
				System.out.println("Please Enter your search option to get your desired book \n1.BookName \n2.Author");
				//this nextLine gets called because nextInt always gets input and leaves a new line , So to avoid confusion nextLine gets the new line as input 
				int value = scan.nextInt();
				scan.nextLine();
				switch(value) {
					case 1 :
						System.out.println("Enter your bookname to check the availability of book in our library");
						book_name = scan.nextLine();
						bookimpl.findBook(bookcollection , book_name , scan , option);
					break;
						
					case 2 :
						System.out.println("Enter your Author name to find the list of Books in our library ");
						String author = scan.nextLine();
						try {
							if(bookimpl instanceof FindBookOperationImpl) {
								//Here findBookByAuthor a new method only present in FindBookOperationImpl and not present in BookOperationImpl.So java casting it to child class type to access the method .						
								((FindBookOperationImpl) bookimpl).findBookByAuthor(bookcollection , author ,scan);
							}
						}catch(ClassCastException e) {
							System.out.println(e);
						}
					break ;
				}
			break ;//case 1 break of outer switch
				
			case 2 :
				System.out.println("Please Enter your book name ");
				book_name = scan.nextLine();
				bookimpl.findReturnBook(bookcollection, book_name, scan);
				
				System.out.println("Please Enter your return date provided for the book in (yyyy-MM-dd)");
				String date = scan.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				try {
					LocalDate due_date = LocalDate.parse(date, formatter);
					bookimpl.returnBook(bookcollection, due_date , book_name);
				}catch(DateTimeParseException e) {
					System.out.println(e);
				}
				
			break ;
			case 3 :
				System.out.println("Please Enter the book you want to borrow ");
				book_name = scan.nextLine();
				//bookcollection , Ponniyin Selvan-1 , scan , 3
				bookimpl.findBook(bookcollection , book_name , scan , option);
				
			break;
			case 4 :
				System.out.println("The List of all books and their availability ");
				for(Book b : bookcollection) {
					System.out.println(b);
				}
			break ;
			default :
				System.out.println("Invalid option ");
			break ;
				
		}
		
	}
}