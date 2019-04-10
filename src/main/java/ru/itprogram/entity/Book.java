package ru.itprogram.entity;

import java.util.Objects;

public class Book {
    private Author author;
    private String numberOfPages;
    private String title;
    private String publisher;

    public Book(Author author, String numberOfPages, String title, String publisher) {
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.title = title;
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) &&
                Objects.equals(numberOfPages, book.numberOfPages) &&
                Objects.equals(title, book.title) &&
                Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, numberOfPages, title, publisher);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", numberOfPages='" + numberOfPages + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
