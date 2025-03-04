package entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book bookId;
    private Date reviewDate;
    private String reviwerUserName;
    private Integer reviewRate;


    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviwerUserName() {
        return reviwerUserName;
    }

    public void setReviwerUserName(String reviwerUserName) {
        this.reviwerUserName = reviwerUserName;
    }

    public int getReviewRate() {
        return reviewRate;
    }

    public void setReviewRate(int reviewRate) {
        this.reviewRate = reviewRate;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }
}
