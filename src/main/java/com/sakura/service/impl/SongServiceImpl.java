package com.sakura.service.impl;

import com.sakura.dao.SongDao;
import com.sakura.domain.Song;
import com.sakura.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongDao songDao;
    @Override
    public List<Song> getSongBySingerId(int singerId) {
        return songDao.getSongBySingerId(singerId);
    }

    @Override
    public List<Song> getSongBySingerName(String name) {
        return songDao.getSongBySingerName(name);
    }

    @Override
    public List<Song> getSongById(int id) {
        return songDao.getSongById(id);
    }
}
