import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Library {	

	ArrayList<Book> books = new ArrayList<>();
	
	public void addBook(Book book) {
		for(Book b : books) {
			if(b.getId() == book.getId()) {
				System.out.println("⚠ Book id already exists.\n");
				return;
			}
		}
		books.add(book);
		System.out.println("✔ Book added to the library successfully.\n");
	}
	
	public void displayBook() {
		if(books.size() == 0) {
			System.out.println("⚠ No books in library.\n");
		} else {
			System.out.println("\n=================================================");
			System.out.println("              📚 LIBRARY BOOK LIST               ");
			System.out.println("=================================================");
			for(Book b : books) {
				b.displayBookInfo();
			}
			System.out.println("=================================================\n");
		}
	}
	
	public void borrowBook(int id) {
		for(Book b : books) {
			if(b.getId() == id) {
				b.borrowBook();
				return;
			}
		}
		System.out.println("⚠ Book not found\n");
	}
	
	public void returnBook(int id) {
		for(Book b : books) {
			if(b.getId() == id) {
				b.returnBook();
				return;
			}
		}
		System.out.println("⚠ Book not found\n");
	}
	
	public void searchBook(int id) {
		for(Book b : books) {
			if(b.getId() == id) {
				System.out.println("\n--- Search Result ---");
				b.displayBookInfo();
				return;
			}
		}
		System.out.println("⚠ Book not found\n");
	}
	
	public void borrowedBook() {
		int borrowBook = 0;
		for(Book b : books) {
			if(b.getIsBorrowed() == true) {
				borrowBook++;
			}
		}
		System.out.println("📊 Number of borrowed books: " + borrowBook + "\n");
	}
	
	public void availableBook() {
		if(books.size() == 0) {
			System.out.println("⚠ No books in library\n");
			return;
		}
		
		boolean found = false;
		System.out.println("\n--- Available Books ---");
		for(Book b : books) {
			if(b.getIsBorrowed() == false) {
				b.displayBookInfo();
				found = true;
			}
		}
		
		if(found == false) {
			System.out.println("⚠ No available books found\n");	
		}
	}
	
	public void removeBook(int id) {
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getId() == id) {
				if(books.get(i).getIsBorrowed() == true) {
					System.out.println("⚠ Cannot remove a borrowed book\n");
					return;
				}
				books.remove(i);
				System.out.println("✔ Book removed successfully\n");
				fileSave();
				return;
			}
		}
		System.out.println("⚠ Book not found\n");
	}
	
	public void fileSave() {
		try {
			FileWriter writer = new FileWriter("Bookk.txt");
			for(Book b : books) {
				writer.write(b.stringToFile() + "\n");
			}
			writer.close();
		} catch(IOException e) {
			System.out.println("Error file saving.");
		}
	}
	
	public void loadFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Bookk.txt"));
			String line;
			while((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				String type = data[0];
				int id = Integer.parseInt(data[1]);
				String title = data[2];
				String author = data[3];
				boolean borrowed = Boolean.parseBoolean(data[4]);
				
				Book book = null;
				if(type.equals("BOOK")) {
					book = new Book(id, title, author);
				} else if(type.equals("EBOOK")) {
					int size = Integer.parseInt(data[5]);
					String pdf = data[6];
					book = new EBook(id, title, author, size, pdf);
				} else if(type.equals("PRINTED")) {
					int pages = Integer.parseInt(data[5]);
					book = new PrintedBook(id, title, author, pages);
				}
				
				if(book != null) {
					book.setBorrowed(borrowed);
					books.add(book);
				}
			}
			reader.close();
			System.out.println("📂 Loading library data...\n✔ Books loaded successfully.\n");
		} catch(IOException e) {
			// لە یەکەم رەن کردن دەکرێت فایلەکە بونی نەبێت ، کە شتێکە ئاساییە
		}
	}
	
	public void showBorrowedBook() {
		boolean found = false;
		System.out.println("\n--- Borrowed Books ---");
		for(Book b : books) {
			if(b.getIsBorrowed() == true) {
				b.displayBookInfo();
				found = true;
			}
		}
		if(found == false) {
			System.out.println("⚠ No books are currently borrowed\n");
		}
	}
}









