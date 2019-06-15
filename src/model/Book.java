package model;


/**
 *
 * @author edgar
 */
public class Book {
    private String isbn;
    private short year;
    private String author;
    private String title;
    private short rating;
    private String condition;
    private String rarity;
    
    public Book(String isbn, short year, String author, String title, short rating, String condition, String rarity) {
        this.isbn = isbn;
        this.year = year;
        this.author = author;
        this.title = title;
        this.rating = rating;
        this.condition = condition;
        this.rarity = rarity;
    }

    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        if (isbn.length() == 10) {
            this.isbn = isbn;
        } else {
            System.out.println("Passed ISBN number is not supported");
        }
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        if (year > 0) {
            this.year = year;
        } else {
            System.out.println("Passed year is not supported");
        }
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public short getRating() {
        return rating;
    }

    public String getCondition() {
        return condition;
    }

    public String getRarity() {
        return rarity;
    }

    public void setAuthor(String author) {
        if (author != null && !author.isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Passed author is not supported");
        }
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Passed title is not supported");
        }
    }

    public void setRating(short rating) {
        if (rating > 0 && rating <= 10) {
            this.rating = rating;
        } else {
            System.out.println("Passed rating is not supported");
        }
    }

    public void setCondition(String condition) {
        if (condition != null && !condition.isEmpty()) {
            this.condition = condition;
        } else {
            System.out.println("Passed title is not supported");
        }
    }

    public void setRarity(String rarity) {
        if (rarity != null && !rarity.isEmpty()) {
            this.rarity = rarity;
        } else {
            System.out.println("Passed title is not supported");
        }
    }
    
    public void changeCondition(String cond) {
        
    }
}
