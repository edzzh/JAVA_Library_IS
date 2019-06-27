package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author edgar
 */
public class LibraryDepartment {
    private ArrayList<Book> bookList;
    private String specialization;
    private ArrayList<String> employees;
    private ArrayList<String> workingTime;
    
    public LibraryDepartment(ArrayList<Book> bookList, String specialization, ArrayList<String> employees, ArrayList<String> workingTime) {
        this.bookList = bookList;
        this.specialization = specialization;
        this.employees = employees;
        this.workingTime = workingTime;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public String getSpecialization() {
        return specialization;
    }

    public ArrayList<String> getEmployees() {
        return employees;
    }

    public ArrayList<String> getWorkingTime() {
        return workingTime;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.isEmpty()) {
            this.specialization = specialization;
        } else {
            System.out.println("Passed specialization is not supported");
        }
    }

    public void setEmployees(ArrayList<String> employees) {
        this.employees = employees;
    }

    public void setWorkingTime(ArrayList<String> workingTime) {
        this.workingTime = workingTime;
    }
    
    public void bookQueForFutureCheckout(Date date) {
        // Customer gives date when he wants to book book
    }
    
    public void giveBook() {
        
    }
    
    public void takeBook() {
        
    }
    
    public void addBook() {
        // Add book into customer list
    }
    
    public void removeBook() {
        // Remove book from the book list
    }
}
