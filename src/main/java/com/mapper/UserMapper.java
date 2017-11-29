package com.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by blues on 2017/11/7.
 */
public interface UserMapper {
    @Select("SELECT id FROM test1")
    @Results({
            @Result(property = "id",  column = "id", javaType = Integer.class)
    })
    List<Integer> getAll();
}
