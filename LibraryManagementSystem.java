import java.util.Scanner;
class LibraryManagementSystem {
    public static void main(String args[]) {

        Book[] booksArray = new Book[50];
        Member[] membersArray = new Member[50];
       

        while(true){
        System.out.println("1.Add book:");
        System.out.println("2.Add Member:");
        System.out.println("3.Borrow Book:");
        System.out.println("4.Return Book:");
        System.out.println("5.Display Available Books:");
        System.out.println("6.Display Borrowed Books:");
        System.out.println("7.Search Book By Title:");
        System.out.println("8.Search Book By Author:");
        System.out.println("9.Exit:");


        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 1:
                Book book = new Book();
                book.addBook();
                book.addBookToArray(booksArray);
                System.out.println("Book Added Successfully");
                break;
            case 2:
                Member member = new Member();
                member.addMember();
                member.addMemberToArray(membersArray);
                System.out.println("Member Added Successfully");
                break;
            case 3:
                Transaction.borrowBook(booksArray); 
                break;
            case 4:
                Transaction.returnBook(booksArray);
                break;
            case 5:
                Book.DisplayAvailableBooks(booksArray);
                break;
            case 6:
                Transaction.displayBorrowedBooks(booksArray);
                break;
            case 7:
                Library.searchBook(booksArray);
                break;
            case 8:
            	Library.searchBookbyAuthor(booksArray);
            	break;
            case 9:
            	 System.out.println("Exiting the Library Management System. Goodbye!");
                 System.exit(0);
                 break;	    
            default:
                System.out.println("Invalid Input!");
        	}
   		}
    }
}

class Book {
    private String title;
    private String author;
    private String genre;
    private boolean borrowed;

    public void addBook() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the Book Title:");
        this.title = sc1.nextLine();

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter the Book Author:");
        this.author = sc2.nextLine();

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter the Book Genre:");
        this.genre = sc3.nextLine();
    }

    public void addBookToArray(Book[] booksArray) {
       
        for (int i = 0; i < booksArray.length; i++) {
            if (booksArray[i] == null) {
                booksArray[i] = this;
                break;
            }
        }
    }

public static void DisplayAvailableBooks(Book[] booksArray){
    boolean availableBooksExist = false;

    System.out.println("Available Books:");
    for(Book book : booksArray){
        if(book != null && !book.isBorrowed()){
            System.out.println("Title:" +book.getTitle()+ " Author:"  +book.getAuthor()+ " Genre:" +book.getGenre());
            availableBooksExist = true;
        }
    }

    if (!availableBooksExist) {
        System.out.println("No available books at the moment.");
    }
}

    public String getTitle(){
    	return title;
    }

    public String getAuthor(){
    	return author;
    }

    public String getGenre(){
    	return genre;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void borrowBook() {
        borrowed = true;
    }

    public void returnBook() {
        borrowed = false;
	}

}

class Member {
    private String memberName;

    public void addMember() {
        Scanner sc4 = new Scanner(System.in);
        System.out.println("Enter the Member Name:");
        this.memberName = sc4.nextLine();
    }

    public void addMemberToArray(Member[] membersArray) {

        for (int i = 0; i < membersArray.length; i++) {
            if (membersArray[i] == null) {
                membersArray[i] = this;
                break;
            }
        }
    }
}

class Transaction {
    public static void borrowBook(Book[] booksArray) {
        Scanner scanner = new Scanner(System.in);

        Book.DisplayAvailableBooks(booksArray); 

        System.out.println("Enter the book title you want to borrow:");
        String bookTitle = scanner.nextLine();

        Book selectedBook = findBookByTitle(bookTitle, booksArray); 

        if (selectedBook != null) {
           
            if (!selectedBook.isBorrowed()) {
                selectedBook.borrowBook();
                System.out.println("Book Borrowed Successfully.");
            } else {
                System.out.println("Sorry, the book is already borrowed.");
            }
        } else {
            System.out.println("Book Not Found!");
        }
    }

   public static void returnBook(Book[] booksArray) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the book title you want to return:");
        String bookTitle = scanner.nextLine();

        Book returnedBook = findBookByTitle(bookTitle, booksArray); // Find the returned book

        if (returnedBook != null) {
           
            if (returnedBook.isBorrowed()) {
                returnedBook.returnBook();
                System.out.println("Book Returned Successfully.");
            } else {
                System.out.println("Sorry, the book was not borrowed.");
            }
        } else {
            System.out.println("Book Not Found!");
        }
    }

    private static Book findBookByTitle(String title, Book[] booksArray) {
        for (Book book : booksArray) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) { // .equalsIgnoreCase is the built-in method
                return book;
            }
        }
        return null;
    }

    public static void displayBorrowedBooks(Book[] booksArray){
        boolean borrowedBooksExist = false;

        System.out.println("Borrowed Books Are:");
        for(Book book : booksArray){
            if(book != null && book.isBorrowed()){
                System.out.println("Title:" + book.getTitle() + "Author:" + book.getAuthor() + "Genre:" + book.getGenre());
                borrowedBooksExist = true;
            }
        }
         if(!borrowedBooksExist){
                System.out.println("No Books Are Currently Borrowed");
            }
    }
}

    class Library{
        public static void searchBook(Book[] booksArray) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the title of Book:");
        String titleToSearch = in.nextLine();

        boolean bookFound = false;

        for (Book book : booksArray) {
            if (book != null && book.getTitle().equalsIgnoreCase(titleToSearch)) {
                System.out.println("Title: " + book.getTitle() + " Author: " + book.getAuthor() +
                 " Genre: " + book.getGenre() + " Status: " + (book.isBorrowed() ? "Borrowed" : "Available"));
                bookFound = true;
                break;  
            }
        }

        if (!bookFound) {
            System.out.println("No Books Found for this Title.");
        }
    }

    public static void searchBookbyAuthor(Book[] booksArray){
        Scanner in1 = new Scanner(System.in);
        System.out.println("Enter the Author Name:");
        String Author = in1.nextLine();

        boolean bookfound = false;

        for(Book book : booksArray){
            if(book != null && book.getTitle().equalsIgnoreCase(Author)){
                System.out.println("Title:" + book.getTitle() + "Author:" + book.getAuthor() + "Genre:" + book.getGenre() + 
                    "Status:" + (book.isBorrowed() ? "Borrowed" : "Available"));
            }
            bookfound = true;
            break;
        }
        if(!bookfound){
            System.out.println("No Books Found for this Author.");
        }
    }
}