package com.sakura.service;

import com.sakura.domain.Song;
import java.util.List;

public interface SongService {
    List<Song> getSongBySingerId(int singerId);
    List<Song> getSongBySingerName(String name);
    List<Song> getSongById(int id);
}
