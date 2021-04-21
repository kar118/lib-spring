package com.example.libspring.models;

public class Book {
    protected static Integer idGenerator = 0;
    protected Integer id;
    protected String title;
    protected String author;
    protected Integer year;

    public Book(String title, String author, Integer year) {
        this.id = getIdGenerator();
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public static Integer getIdGenerator() {
        return ++idGenerator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
