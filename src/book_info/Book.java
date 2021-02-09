package book_info;

public class Book {
    private int isbn;
    private String author;
    private String title;
    private String resume;
    private double[] rating = new double[3];

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public double getRating() {
        return rating[2];
    }

    public void setRating(int currentVote) {

        this.rating[0] += currentVote;
        this.rating[1] ++;
        this.rating[2] = Math.round(this.rating[0]/this.rating[1]*100.00)/100.00;

    }

    public String toString() {
        return "ISBN:" + this.isbn +
                " Author: " + this.author +
                " Title: " + this.title +
                " Resume: " + this.resume +
                " Rating:" + this.rating[2];
    }
}
