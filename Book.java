import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private String publicationDate;
    private Student currentBorrower;

    public Book(String title, String author, String ISBN, String publicationDate) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Student getCurrentBorrower() {
        return currentBorrower;
    }

    public void setCurrentBorrower(Student currentBorrower) {
        this.currentBorrower = currentBorrower;
    }

    public void borrowBook(Student student) {
        this.currentBorrower = student;
    }

    public void returnBook() {
        this.currentBorrower = null;
    }

    public void modifyBook(String newTitle, String newAuthor, String newPublicationDateStr) {
        this.title = newTitle;
        this.author = newAuthor;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date newPublicationDate = dateFormat.parse(newPublicationDateStr);
            this.publicationDate = dateFormat.format(newPublicationDate);
        } catch (ParseException e) {
            System.out.println("Incorrect date format. Book details not updated.");
        }
    }

    public static void displayBookDetails(Book book) {
        System.out.println("Book Details:");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getISBN());
        System.out.println("Publication Date: " + book.getPublicationDate());

        if (book.getCurrentBorrower() != null) {
            System.out.println("Borrowed by: " + book.getCurrentBorrower().getName());
        } else {
            System.out.println("Not currently borrowed.");
        }
    }
}
