package com.example.libspring.controllers;

import com.example.libspring.exceptions.LibraryException;
import com.example.libspring.models.Book;
import com.example.libspring.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DashboardController {
    private DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard")
    public ResponseEntity getBooks() {
        List<Book> books = dashboardService.getBooks();
        if(books != null)
            return new ResponseEntity<>(books, HttpStatus.OK);
        throw new LibraryException("There are no books in the library.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/dashboard/{id}")
    public ResponseEntity getBook(@PathVariable Integer id) {
        Book foundBook = dashboardService.getBook(id);
        if(foundBook != null)
            return new ResponseEntity<>(foundBook, HttpStatus.OK);
        throw new LibraryException("There is no book with such id.", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/dashboard")
    public ResponseEntity addBook(@RequestBody Book book) {
        if(dashboardService.addBook(book))
            return new ResponseEntity<>(dashboardService.getBooks(), HttpStatus.CREATED);
        throw new LibraryException("Cannot add this book to the library.", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/dashboard/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) {
        Book removedBook = dashboardService.deleteBook(id);
        if (removedBook != null)
            return new ResponseEntity<>(removedBook, HttpStatus.OK);
        throw new LibraryException("There is no book with such id.", HttpStatus.NOT_FOUND);
    }
}
