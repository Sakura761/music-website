package com.sakura.service.impl;

import com.sakura.dao.SongListDao;
import com.sakura.domain.SongList;
import com.sakura.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongListServiceImpl implements SongListService {
    @Autowired
    SongListDao songListDao;

    @Override
    public List<SongList> getSongList() {
        return songListDao.getSongList();
    }

    @Override
    public List<SongList> getSongListByStyle(String style) {
        return songListDao.getSongListByStyle(style);
    }
}
