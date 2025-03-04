package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;
    private String bookGenre;
    private Date releaseDate;
    private String editor;
    private double price;
    @ManyToOne
    @JoinColumn(name = "bookStoreId")
    Bookstore bookStoreId;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookStoreId() {
        return bookStoreId;
    }

    public void setBookStoreId(int bookStoreId) {
        this.bookStoreId = bookStoreId;
    }
}
