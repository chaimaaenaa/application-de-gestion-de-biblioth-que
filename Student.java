import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String name;
    private String address;
    private String studentID;
    private List<Book> borrowedBooks;

    public Student(String name, String address, String studentID) {
        this.name = name;
        this.address = address;
        this.studentID = studentID;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setCurrentBorrower(this);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setCurrentBorrower(null);
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void removeStudent(List<Student> students, String studentID) {
        Student studentToRemove = findStudentByID(students, studentID);
        if (studentToRemove != null) {
            students.remove(studentToRemove);
        } else {
            System.out.println("Student not found with this ID.");
        }
    }

    public static Student findStudentByID(List<Student> students, String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public static void modifyStudent(List<Student> students, String studentID, Student modifiedStudent) {
        Student existingStudent = findStudentByID(students, studentID);
        if (existingStudent != null) {
            existingStudent.setName(modifiedStudent.getName());
            existingStudent.setAddress(modifiedStudent.getAddress());
        } else {
            System.out.println("Student not found with this ID.");
        }
    }
}
