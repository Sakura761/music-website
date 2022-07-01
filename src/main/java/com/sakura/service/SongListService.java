package com.sakura.service;

import com.sakura.domain.SongList;

import java.util.List;

public interface SongListService {
    List<SongList> getSongList();
    List<SongList> getSongListByStyle(String style);
}
