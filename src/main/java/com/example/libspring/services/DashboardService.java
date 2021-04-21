package com.example.libspring.services;

import com.example.libspring.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DashboardService {
    private ArrayList<Book> books = null;

    public DashboardService() {
        this.books = new ArrayList<>();
        this.books.add(new Book("Ogniem i Mieczem", "Henryk Sienkiewicz", 1884));
        this.books.add(new Book("Potop", "Henryk Sienkiewicz", 1886));
        this.books.add((new Book("Pan Wołodyjowski", "Henryk Sienkiewicz", 1888)));
    }

    public boolean addBook(Book book) {
        return this.books.add(book);
    }

    public Book getBook(Integer id) {
        try {
            return this.books.stream().filter(book -> book.getId().equals(id)).findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }

    public Book deleteBook(Integer id) {
        Book removeBook = this.books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
        this.books.remove(removeBook);
        return removeBook;
    }

    public ArrayList<Book> getBooks() {
        return this.books.isEmpty() == false ? this.books : null;
    }
}
