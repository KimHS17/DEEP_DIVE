package com.example.restapi_ex.repository;

import com.example.restapi_ex.dto.BookDto;
import com.example.restapi_ex.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, String> {
}
