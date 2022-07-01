package com.sakura.dao;

import com.sakura.domain.Song;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SongDao {
    List<Song> getSongBySingerId(int singerId);
    List<Song> getSongBySingerName(String name);
    List<Song> getSongById(int id);
}
