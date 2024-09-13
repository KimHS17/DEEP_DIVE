package com.example.restapi_ex.mapper;

import com.example.restapi_ex.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;

@Mapper
public interface ExMapper {
//    HashMap<String, Object> map = new HashMap<>();
    HashMap<String, Object> findById(HashMap<String, Object> parmMap);

    void registerItem(ItemDto parmMap);
}
