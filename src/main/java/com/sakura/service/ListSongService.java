package com.sakura.service;

import com.sakura.domain.ListSong;

import java.util.List;

public interface ListSongService {
    List<ListSong> getListSongOfSongId(int songListId);
}
