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
    private Book book;
    private Date reviewDate;
    private String reviewText;
    private Integer reviewRate;


    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getreviewText() {
        return reviewText;
    }

    public void setreviewText(String reviewText) {
        this.reviewText = reviewText;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Review Details:").append('\n');
        sb.append("Book: ").append(book.getBookName()).append('\n');
        sb.append("Review: ").append(reviewText).append('\n');
        sb.append("Rating: ").append(reviewRate).append(" / 5").append('\n');
        sb.append("\n-----------------------------\n\n");
        return sb.toString();
    }
}
