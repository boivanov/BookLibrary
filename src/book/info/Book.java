package book.info;

import java.util.ArrayList;
import java.util.HashSet;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String resume;
    private double[] rating = new double[3];
    private HashSet<String> voters = new HashSet<>();

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getRating() {

        return "" + rating[0] + "|" + rating[1];
    }

    public void setRating(double currentVote) {

        this.rating[0] += currentVote;
        this.rating[1]++;
        this.rating[2] = Math.round(this.rating[0] / this.rating[1] * 100.00) / 100.00;

    }

    public String getVoters(){
        return String.join(",", this.voters);
    }

    public void setVoters(HashSet<String> set){
        this.voters.addAll(set);
    }

    public void addVoter(String user){
        this.voters.add(user);
    }

    public String toString() {
        return "ISBN:" + this.isbn +
                ", Title: " + this.title +
                ", Author: " + this.author +
                ", Resume: " + this.resume +
                ", Rating:" + this.rating[2];
    }
}
