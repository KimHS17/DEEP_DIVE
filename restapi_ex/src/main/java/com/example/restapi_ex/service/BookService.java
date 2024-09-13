package com.example.restapi_ex.service;

import com.example.restapi_ex.dto.BookDto;
import com.example.restapi_ex.entity.BookEntity;
import com.example.restapi_ex.mapper.BookMapper;
import com.example.restapi_ex.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getBooks() {
        return bookRepository.findAll();
    }

    public BookEntity getBook(String id) {
        BookEntity book = bookRepository.findById(id).get();
        if(book == null) {
            return null;
        }
        return book;
    }

    public void registerBook(BookEntity book) {
        bookRepository.save(book);
    }

    public void updateBook(String id, BookEntity book) {
        book.setId(id);
        bookRepository.save(book);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
}
