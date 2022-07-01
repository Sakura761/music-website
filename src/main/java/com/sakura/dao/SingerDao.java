package com.sakura.dao;

import com.sakura.domain.Singer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SingerDao {
    List<Singer> getAllSinger();
    List<Singer> getSingerBySex(int sex);
}
