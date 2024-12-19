package com.library.testing;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public interface BookOperation {
	Book findBook(List<Book> bookcollection, String title , Scanner scan, int option);
	void returnBook(List<Book> bookcollection, LocalDate return_date , String book_name);
	void BorrowBook(List<Book> bookcollection , String book_name);
	
}
