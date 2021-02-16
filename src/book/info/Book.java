package book.info;

import java.util.HashSet;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String resume;
    private double sumVotes;
    private double cntVotes;
    private HashSet<String> voters = new HashSet<>();
    private HashSet<String> favorites = new HashSet<>();
    private HashSet<String> reviews = new HashSet<>();
    private HashSet<String> personal = new HashSet<>();
    private String owner;

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

    public double getSumVotes() {

        return this.sumVotes;
    }

    public void setSumVotes(double currentVote) {

        this.sumVotes += currentVote;

    }

    public double getCntVotes(){
        return this.cntVotes;
    }

    public void setCntVotes(double cnt){
        this.cntVotes = cnt;
    }

    public void addCntVotes(){
        this.cntVotes++;
    }

    public HashSet<String> getVoters() {
        return this.voters;
    }

    public void setVoters(HashSet<String> set) {
        this.voters.addAll(set);
    }

    public void addVoter(String user) {
        this.voters.add(user);
    }

    public HashSet<String> getFavorites() {
        return this.favorites;
    }

    public void setFavorites(HashSet<String> set) {
        this.favorites.addAll(set);
    }

    public void addFavorite(String user) {
        this.favorites.add(user);
    }

    public void removeFavorite(String user) {
        this.favorites.remove(user);
    }

    public HashSet<String> getPersonal() {
        return this.personal;
    }

    public void setPersonal(HashSet<String> set) {
        this.personal.addAll(set);
    }

    public void addPersonal(String user) {
        this.personal.add(user);
    }

    public void removePersonal(String user) {
        this.personal.remove(user);
    }

    public HashSet<String> getReviews() {
        return this.reviews;
    }

    public void setReviews(HashSet<String> set) {
        this.reviews.addAll(set);
    }

    public void addReview(String comment) {
        this.reviews.add(comment);
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String toString() {
        return "ISBN: " + this.isbn +
                ", Title: " + this.title +
                ", Author: " + this.author +
                ", Resume: " + this.resume +
                ", Rating:" + Math.round(this.sumVotes / this.cntVotes * 100.00) / 100.00;
    }
}
