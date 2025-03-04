package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bookstore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookstoreId;
    private String name;
    private String title;
    private String genres;
    @OneToMany(mappedBy = "bookstore")
    private List <Book> bookList;

    public int getBookstoreId() {
        return bookstoreId;
    }

    public void setBookstoreId(int bookstoreId) {
        this.bookstoreId = bookstoreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<String> getBookList() {
        return bookList;
    }

    public void setBookList(List<String> bookList) {
        this.bookList = bookList;
    }
}
