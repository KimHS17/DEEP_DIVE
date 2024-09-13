package com.example.restapi_ex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
public class BookEntity {
    @Id
    private String id;
    private String title;
    private String author;
    private String publisher;
    private String published_date;

}
