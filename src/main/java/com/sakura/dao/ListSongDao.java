package com.sakura.dao;

import com.sakura.domain.ListSong;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ListSongDao {
    List<ListSong> getListSongOfSongId(int songListId);
}
