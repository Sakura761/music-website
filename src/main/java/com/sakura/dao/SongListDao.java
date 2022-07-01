package com.sakura.dao;

import com.sakura.domain.SongList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SongListDao {
    List<SongList> getSongList();
    List<SongList> getSongListByStyle(String style);
}
