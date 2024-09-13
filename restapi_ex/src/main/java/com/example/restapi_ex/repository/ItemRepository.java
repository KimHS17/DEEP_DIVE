package com.example.restapi_ex.repository;

import com.example.restapi_ex.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<ItemEntity, String> {

}
