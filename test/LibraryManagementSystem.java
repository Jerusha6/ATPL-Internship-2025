//SECTION B 1Q

package com.aaslin.java.assignments.test;
import java.util.ArrayList;
import java.util.List;

class Book{
	
	private String title;
	private String author;
	private double ISBN;
	public Book(String title, String author, double iSBN) {
		super();
		this.title = title;
		this.author = author;
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public double getISBN() {
		return ISBN;
	}
	
}

class BookNotFoundException extends Exception{

	public BookNotFoundException(String string) {
		super(string);
		System.out.print("The entered book is not found in the library");
	}
	
}

class Library{	
	
	List<Book> list = new ArrayList<>();

	public void addBook(String bookTitle, String bookAuthor, double ISBN) {
		list.add(new Book(bookTitle, bookAuthor, ISBN));
		System.out.println(bookTitle+" successfully added to the library");
	}
	
	public void searchBook(String bookTitle)  throws BookNotFoundException{
		for(Book book : list){
			if(book.getTitle().equalsIgnoreCase(bookTitle)) {
				System.out.print(bookTitle+" is there in the Library");
			}else {
				throw new BookNotFoundException(bookTitle+" is not found");
			}			
		}
	}	
}

public class LibraryManagementSystem {

	public static void main(String[] args) {
		
		Library library = new Library();
		library.addBook("Java programming", "james gosling", 123445);
		try {
			library.searchBook("Java programming");
		}catch(BookNotFoundException be) {
			System.out.println(be.getMessage());
		}
	}

}
