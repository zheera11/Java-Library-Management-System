import java.util.Scanner;

public class Main {
	
   public static void main(String[] args) {
	   
	   Library library = new Library();
	   library.loadFile();
	   
	   Scanner sc = new Scanner(System.in);
	   
	   while(true) {
		   
		   showMenu();
		   
		   int choice;
		   try {
			   System.out.print(" ✨ Choose an option [0-10]: ");
			   choice = sc.nextInt();
			   sc.nextLine(); 
		   } catch(Exception e) {
			   System.out.println("\n❌ Invalid input! Please enter a valid number.\n");
			   sc.nextLine();
			   continue;
		   }
		  
		   System.out.println();
		   
		   switch(choice) {
		   case 1:
			   addBook(library, sc);
			   break;
		   case 2:
			   addEbook(library, sc);
			   break;
		   case 3:
			   addPrintedBook(library, sc);
			   break;
		   case 4:
			   showBooks(library);
			   break;
		   case 5:
			   searchBooks(library, sc);
			   break;
		   case 6:
			   borrowBook(library, sc);
			   break;
		   case 7:
			   returnBook(library, sc);
			   break;
		   case 8:
			   availableBooks(library);
			   break;
		   case 9:
			   borrowedBooks(library);
			   break;
		   case 10:
			   removeBook(library, sc);
			   break;
		   case 0:
			   exit(library);
			   break;
		   default:
			   System.out.println("❌ Wrong choice, please choose between 0 and 10.\n");
			   break;
		   }
		   
		   if(choice == 0) {
			   break;
		   }
		   
		   printLine();
		   System.out.print("Press ENTER to return to the menu...");
		   sc.nextLine();
		   System.out.println("\n");
	   }
   }
   
   public static void showMenu() {
	   System.out.println("╔═══════════════════════════════════════════════╗");
	   System.out.println("║          📚 BOOK LIBRARY SYSTEM 📚            ║");
	   System.out.println("╚═══════════════════════════════════════════════╝");
	   System.out.println(" 1. ➕ Add Standard Book");
	   System.out.println(" 2. 💻 Add E-Book");
	   System.out.println(" 3. 📖 Add Printed Book");
	   System.out.println(" 4. 📋 Show All Books");
	   System.out.println(" 5. 🔍 Search Book by ID");
	   System.out.println(" 6. 📤 Borrow Book");
	   System.out.println(" 7. 📥 Return Book");
	   System.out.println(" 8. 🟢 Show Available Books");
	   System.out.println(" 9. 🔴 Show Borrowed Books");
	   System.out.println(" 10. 🗑️ Remove Book");
	   System.out.println(" 0. 🚪 Exit System");
	   System.out.println("-------------------------------------------------");
   }
   
   public static void addBook(Library library, Scanner sc) {
	   while(true) {
			System.out.println("--- ➕ Add Standard Book Menu ---");
			System.out.println("1. Create book by id");
			System.out.println("2. Create book by id and title");
			System.out.println("3. Create book by id, title, author");
			System.out.println("4. Back to main menu");
			
			int choice;
			try {
				System.out.print(" ✨ Choose an option: ");
				choice = sc.nextInt();
				sc.nextLine();
			} catch(Exception e) {
				System.out.println("❌ Invalid input! Please enter a number.\n");
				sc.nextLine();
				continue;
			}
			
			System.out.println();
			
			if(choice == 1) {
				int id;
				try {
					System.out.print("Enter book ID: ");
					id = sc.nextInt();
					sc.nextLine();
				} catch(Exception e) {
					System.out.println("❌ Invalid input!\n");
					sc.nextLine();
					continue;
				}
				Book book = new Book(id);
				library.addBook(book);
				break;
			}
			else if(choice == 2) {
				int id;
				String title;
				try {
					System.out.print("Enter book ID: ");
					id = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter book title: ");
					title = sc.nextLine();
				} catch(Exception e) {
					System.out.println("❌ Invalid input!\n");
					sc.nextLine();
					continue;
				}
				Book book = new Book(id, title);
				library.addBook(book);
				break;
			}
			else if(choice == 3) {
				int id;
				String title;
				String author;
				try {
					System.out.print("Enter book ID: ");
					id = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter book title: ");
					title = sc.nextLine();
					System.out.print("Enter book author: ");
					author = sc.nextLine();
				} catch(Exception e) {
					System.out.println("❌ Invalid input!\n");
					sc.nextLine();
					continue;
				}
				Book book = new Book(id, title, author);
				library.addBook(book);
				break;
			}
			else if(choice == 4) {
				System.out.println("🔙 Returning to main menu...\n");
				break;
			}
			else {
				System.out.println("❌ Wrong choice, try again.\n");
			}
	   }
   }
   
   public static void addEbook(Library library, Scanner sc) {
	   System.out.println("--- 💻 Add E-Book ---");
	   int id;
	   String title;
	   String author;
	   int fileSize;
	   String format;
	   try {
		  System.out.print("Enter E-Book ID: ");
		  id = sc.nextInt();
		  sc.nextLine();
		  System.out.print("Enter E-Book title: ");
		  title = sc.nextLine();
		  System.out.print("Enter E-Book author: ");
		  author = sc.nextLine();
		  System.out.print("Enter file size (MB): ");
		  fileSize = sc.nextInt();
		  sc.nextLine();
		  System.out.print("Enter format (e.g. PDF/EPUB): ");
		  format = sc.nextLine(); 
		  
		  Book book = new EBook(id, title, author, fileSize, format);
		  library.addBook(book);
	   } catch(Exception e) {
			System.out.println("❌ Invalid input! Please try again.\n");
			sc.nextLine();
	   }
   }
   
   public static void addPrintedBook(Library library, Scanner sc) {
	   System.out.println("--- 📖 Add Printed Book ---");
	   int printedBookId;
	   String title;
	   String author;
	   int pages;
	   try {
		   System.out.print("Enter printed book ID: ");
		   printedBookId = sc.nextInt();
		   sc.nextLine();
		   System.out.print("Enter printed book title: ");
		   title = sc.nextLine();
		   System.out.print("Enter printed book author: ");
		   author = sc.nextLine();
		   System.out.print("Enter number of pages: ");
		   pages = sc.nextInt();
		   sc.nextLine();
		   
		   Book book = new PrintedBook(printedBookId, title, author, pages);
		   library.addBook(book);   
	   } catch(Exception e) {
		   System.out.println("❌ Invalid input! Please try again.\n");
		   sc.nextLine();
	   }
   }
   
   public static void showBooks(Library library) {
	   library.displayBook();
   }
   
   public static void searchBooks(Library library, Scanner sc) {
	   System.out.println("--- 🔍 Search Book ---");
	   int search;
	   try {
		   System.out.print("Enter the book ID to find: ");
		   search = sc.nextInt();
		   sc.nextLine();
		   library.searchBook(search);
	   } catch(Exception e) {
		   System.out.println("❌ Invalid input! Please try again.\n");
		   sc.nextLine();
	   }
   }
   
   public static void borrowBook(Library library, Scanner sc) {
	   System.out.println("--- 📤 Borrow Book ---");
	   int borrow;
	   try {
		   System.out.print("Enter book ID to borrow: ");
		   borrow = sc.nextInt();
		   sc.nextLine();
		   library.borrowBook(borrow);
	   } catch(Exception e) {
		   System.out.println("❌ Invalid input! Please try again.\n");
		   sc.nextLine();
	   }
   }
   
   public static void returnBook(Library library, Scanner sc) {
	   System.out.println("--- 📥 Return Book ---");
	   int id;
	   try {
		   System.out.print("Enter book ID to return: ");
		   id = sc.nextInt();
		   sc.nextLine();
		   library.returnBook(id); 
	   } catch(Exception e) {
		   System.out.println("❌ Invalid input! Please try again.\n");
		   sc.nextLine();
	   }
   }
   
   public static void availableBooks(Library library) {
	   library.availableBook();
   }
   
   public static void borrowedBooks(Library library) {
	   library.showBorrowedBook();
   }
   
   public static void removeBook(Library library, Scanner sc) {
	   System.out.println("--- 🗑️ Remove Book ---");
	   int remove;
	   try {
		   System.out.print("Enter book ID to remove: ");
		   remove = sc.nextInt();
		   sc.nextLine();
		   library.removeBook(remove);  
	   } catch(Exception e) {
		   System.out.println("❌ Invalid input! Please try again.\n");
		   sc.nextLine();
	   }
   }
   
   public static void exit(Library library) {
	   library.fileSave();
	   System.out.println("\n╔═══════════════════════════════════════════════╗");
	   System.out.println("║   👋 Thank you for using the Library System!  ║");
	   System.out.println("║                Goodbye! ✨                    ║");
	   System.out.println("╚═══════════════════════════════════════════════╝");
   }
   
   public static void printLine() {
	   System.out.println("-------------------------------------------------");
   }
}