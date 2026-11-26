public class Book {

	protected int id;
	protected String title;
	protected String author;
	protected boolean isBorrowed;
	
	public Book(int id) {
		this.id = id;
	}
	
	public Book(int id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public Book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public boolean getIsBorrowed() {
		return this.isBorrowed;
	}
	
	public void displayBookInfo() {
		String state;
		if(isBorrowed == false) {
			state = "🟢 Available";
		} else {
			state = "🔴 Borrowed";
		}
		
		if(title == null) {
			this.title = "Unknown title";
		}
		
		if(author == null) {
			this.author = "Unknown author";
		}
		
		System.out.println("┌───────────────────────────────────────────────");
		System.out.println("│ 📖 Type: Standard Book");
		System.out.println("│ ID    : " + this.id);
		System.out.println("│ Title : " + this.title);
		System.out.println("│ Author: " + this.author);
		System.out.println("│ Status: " + state);
		System.out.println("└───────────────────────────────────────────────");
	}
	
	public void borrowBook() {
		if(isBorrowed == false) {
			System.out.println("✔ Book borrowed successfully\n");
			isBorrowed = true;
		}else {
			System.out.println("⚠ The book is already borrowed\n");
		}
	}
	
	public void returnBook() {
		if(isBorrowed == true) {
			System.out.println("✔ Book returned successfully\n");
			isBorrowed = false;
		}else {
			System.out.println("⚠ The book was not borrowed\n");
		}
	}
	
	public void setBorrowed(boolean borrowed) {
		this.isBorrowed = borrowed;
	}
	
	public String stringToFile() {
		return "BOOK," + id + "," + title + "," + author + "," + isBorrowed;
	}
}