package com.example.restapi_ex.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDto {
    private String id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate published_date;
}
