public class PrintedBook extends Book {

	private int pages;
	
	public PrintedBook(int id, String title, String author, int pages) {
		super(id, title, author);
		this.pages = pages;
	}
	
	@Override
	public void displayBookInfo() {
		String state;
		if(super.isBorrowed == false) {
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
		System.out.println("│ 📚 Type: Printed Book");
		System.out.println("│ ID    : " + this.id);
		System.out.println("│ Title : " + this.title);
		System.out.println("│ Author: " + this.author);
		System.out.println("│ Pages : " + this.pages);
		System.out.println("│ Status: " + state);
		System.out.println("└───────────────────────────────────────────────");
	}
	
	@Override
	public String stringToFile() {
		return "PRINTED," + id + "," + title + "," + author + "," + isBorrowed + "," + pages;
	}
}
