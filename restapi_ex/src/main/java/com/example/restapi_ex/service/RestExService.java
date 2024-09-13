package com.example.restapi_ex.service;

import com.example.restapi_ex.dto.ItemDto;
import com.example.restapi_ex.entity.ItemEntity;
import com.example.restapi_ex.mapper.ExMapper;
import com.example.restapi_ex.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class RestExService {
    @Autowired
    private ExMapper exMapper;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private SessionFactory sessionFactory;

    public boolean registerItem(ItemDto itemDto) {
//        exMapper.registerItem(itemDto);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());
//        itemRepository.save(itemEntity);
        session.save(itemEntity);
        session.getTransaction().commit();
        session.close();
        log.info("registerItem: " + itemDto);
        return true;
    }

    public ItemDto getItem(String id) {
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", id);
//
//        HashMap<String, Object> res = exMapper.findById(paramMap);

//        ItemEntity itemEntity = itemRepository.findById(id).get();

        Session session = sessionFactory.openSession();
        ItemEntity itemEntity = session.get(ItemEntity.class, id);
        session.close();

        if(itemEntity == null) {
            return null;
        }

        ItemDto itemDto = new ItemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());

        return itemDto;
    }
}
