package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "book")
    List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "bookStoreId")
    Bookstore bookstore;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

    public Book() {
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }


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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Bookstore getBookStoreId() {
        return bookstore;
    }

    public void setBookStoreId(Bookstore bookStoreId) {
        this.bookstore = bookStoreId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("bookName='").append(bookName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
