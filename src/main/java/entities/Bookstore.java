package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bookstore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookstoreId;
    private String name;

    @OneToMany(mappedBy = "bookstore")
    private List <Book> bookList;

    public Bookstore(String bookstoreName) {
        this.name = bookstoreName;
    }

    public Bookstore() {
    }

    public Bookstore(Integer bookstoreId, String name, List<Book> bookList) {
        this.bookstoreId = bookstoreId;
        this.name = name;
        this.bookList = bookList;
    }

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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bookstore{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
