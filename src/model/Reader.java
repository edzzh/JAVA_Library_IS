package model;

import java.util.ArrayList;

/**
 *
 * @author edgar
 */
public class Reader {
    private String name;
    private String surname;
    private int libraryUserNumber;
    private ArrayList<Book> currentTakenBookList;
    
    public Reader(String name, String surname, int libraryUserNumber, ArrayList<Book> currentBookList) {
        this.name = name;
        this.surname = surname;
        this.libraryUserNumber = libraryUserNumber;
        this.currentTakenBookList = currentBookList;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getLibraryUserNumber() {
        return libraryUserNumber;
    }

    public ArrayList<Book> getCurrentTakenBookList() {
        return currentTakenBookList;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Passed name is not supported");
        }
    }

    public void setSurname(String surname) {
        if (surname != null && !surname.isEmpty()) {
            this.surname = surname;
        } else {
            System.out.println("Passed surname is not supported");
        }
    }

    public void setLibraryUserNumber(int libraryUserNumber) {
        if (libraryUserNumber > 0) {
            this.libraryUserNumber = libraryUserNumber;
        } else {
            System.out.println("Passed library user number is not supported");
        }
    }

    public void setCurrentTakenBookList(ArrayList<Book> currentTakenBookList) {
        this.currentTakenBookList = currentTakenBookList;
    }
    
    public void loadHistory() {
        
    }
}
