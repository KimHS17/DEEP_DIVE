package com.example.restapi_ex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ITEM")
@Getter
@Setter
public class ItemEntity {
    @Id
    private String id;
    private String name;
}
