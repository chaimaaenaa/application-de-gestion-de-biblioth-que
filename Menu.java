import java.util.List;
import java.util.Scanner;

public class Menu {
    private Library library;
    private List<Student> students;

    public Menu(Library library, List<Student> students) {
        this.library = library;
        this.students = students;
    }

    public void displayMenu() {
        int choice;
        do {
            displayOptions();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    modifyBook();
                    break;
                case 5:
                    displayBookList();
                    break;
                case 6:
                    addStudent();
                    break;
                case 7:
                    modifyStudent();
                    break;
                case 8:
                    removeStudent();
                    break;
                case 9:
                    searchStudent();
                    break;
            }
        } while (choice != 10);
    }

    private void displayOptions() {
        System.out.println("..............................Menu book.............................");
        System.out.println("1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. Search for a book");
        System.out.println("4. Modify a book");
        System.out.println("5. Display book list");
        System.out.println("...........................................................");
        System.out.println("..............................Menu student.............................");
        System.out.println("6. Add a student");
        System.out.println("7. Modify a student");
        System.out.println("8. Remove a student");
        System.out.println("9. Search for a student");
        System.out.println("10. Exit");
        System.out.println("...........................................................");
    }

    private int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();
        System.out.print("Enter the ISBN of the book: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter the publication date of the book (yyyy-MM-dd): ");
        String publicationDate = scanner.nextLine();

        Book newBook = new Book(title, author, ISBN, publicationDate);
        library.addBook(newBook);
        System.out.println("Book added successfully!");
    }

    private void removeBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book to remove: ");
        String title = scanner.nextLine();

        Book bookToRemove = library.findBookByTitle(title);
        if (bookToRemove != null) {
            library.removeBook(bookToRemove);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found with this title.");
        }
    }

    private void searchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book to search: ");
        String title = scanner.nextLine();

        Book foundBook = library.findBookByTitle(title);
        if (foundBook != null) {
            System.out.println("Book found:");
            displayBookDetails(foundBook);
        } else {
            System.out.println("Book not found with this title.");
        }
    }

    private void modifyBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book to modify: ");
        String title = scanner.nextLine();

        Book bookToModify = library.findBookByTitle(title);
        if (bookToModify != null) {
            System.out.print("Enter the new title of the book: ");
            String newTitle = scanner.nextLine();
            System.out.print("Enter the new author of the book: ");
            String newAuthor = scanner.nextLine();
            System.out.print("Enter the new publication date of the book (yyyy-MM-dd): ");
            String newPublicationDate = scanner.nextLine();

            bookToModify.modifyBook(newTitle, newAuthor, newPublicationDate);
            System.out.println("Book modified successfully!");
        } else {
            System.out.println("Book not found with this title.");
        }
    }

    private void displayBookList() {
        System.out.println("List of Books:");
        for (Book book : library.getBooks()) {
            displayBookDetails(book);
        }
    }

    private void displayBookDetails(Book book) {
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

    private void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the student: ");
        String name = scanner.nextLine();
        System.out.print("Enter the address of the student: ");
        String address = scanner.nextLine();
        System.out.print("Enter the student ID: ");
        String studentID = scanner.nextLine();

        Student newStudent = new Student(name, address, studentID);
        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    private void modifyStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student ID to modify: ");
        String studentID = scanner.nextLine();

        Student studentToModify = findStudentByID(studentID);
        if (studentToModify != null) {
            System.out.print("Enter the new name of the student: ");
            String newName = scanner.nextLine();
            System.out.print("Enter the new address of the student: ");
            String newAddress = scanner.nextLine();

            studentToModify.setName(newName);
            studentToModify.setAddress(newAddress);
            System.out.println("Student modified successfully!");
        } else {
            System.out.println("Student not found with this ID.");
        }
    }

    private void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student ID to remove: ");
        String studentID = scanner.nextLine();

        Student studentToRemove = findStudentByID(studentID);
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found with this ID.");
        }
    }

    private void searchStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student ID to search: ");
        String studentID = scanner.nextLine();

        Student foundStudent = findStudentByID(studentID);
        if (foundStudent != null) {
            System.out.println("Student found:");
            displayStudentDetails(foundStudent);
        } else {
            System.out.println("Student not found with this ID.");
        }
    }

    private void displayStudentDetails(Student student) {
        System.out.println("Name: " + student.getName());
        System.out.println("Address: " + student.getAddress());
        System.out.println("Student ID: " + student.getStudentID());
    }

    private Student findStudentByID(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }


}
