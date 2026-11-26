public class EBook extends Book {

	private int fileSize;
	private String pdf;
	
	public EBook(int id, String title, String author, int fileSize, String pdf) {
		super(id, title, author);
		this.fileSize = fileSize;
		this.pdf = pdf;
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
		System.out.println("│ 💻 Type: E-Book");
		System.out.println("│ ID       : " + this.id);
		System.out.println("│ Title    : " + this.title);
		System.out.println("│ Author   : " + this.author);
		System.out.println("│ File Size: " + this.fileSize + " MB");
		System.out.println("│ Format   : " + this.pdf);
		System.out.println("│ Status   : " + state);
		System.out.println("└───────────────────────────────────────────────");
	}
	
	@Override
	public String stringToFile() {
		return "EBOOK," + id + "," + title + "," + author + "," + super.isBorrowed + "," + fileSize + "," + pdf;
	}
}
