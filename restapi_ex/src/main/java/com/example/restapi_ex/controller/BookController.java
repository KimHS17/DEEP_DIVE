package com.example.restapi_ex.controller;

import com.example.restapi_ex.dto.BookDto;
import com.example.restapi_ex.entity.BookEntity;
import com.example.restapi_ex.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BookController {
    @Autowired
    private BookService bookService;

    // http://localhost:8080/books
    @GetMapping("/books")
    public List<BookEntity> getBooks() {
        log.info("getBooks");
        return bookService.getBooks();
    }

    // http://localhost:8080/books/search?title=룩백
    @GetMapping("/books/search")
    public BookEntity getBook(@RequestParam String id) {
        log.info("getBook: " + id);
        return bookService.getBook(id);
    }

    @PostMapping("/books")
    public void registerBook(@RequestBody BookEntity book) {
        log.info("registerBook: " + book);
        bookService.registerBook(book);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable String id, @RequestBody BookEntity book) {
        log.info("updateBook: " + id + " " + book);
        bookService.updateBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable String id) {
        log.info("deleteBook: " + id);
        bookService.deleteBook(id);
    }
}
