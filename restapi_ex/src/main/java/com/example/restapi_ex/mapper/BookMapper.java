package com.example.restapi_ex.mapper;

import com.example.restapi_ex.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BookMapper {
    List<BookDto> findAll();
    BookDto findByTitle(String title);

    void registerBook(BookDto book);

    void updateBook(BookDto book);

    void deleteBook(String id);
}
