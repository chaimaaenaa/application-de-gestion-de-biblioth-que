import java.util.List;

public class Library {
    private List<Book> books;
    private List<Student> students;

    public Library(List<Book> books, List<Student> students) {
        this.books = books;
        this.students = students;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    // Implement the getBooks method
    public List<Book> getBooks() {
        return books;
    }
}
