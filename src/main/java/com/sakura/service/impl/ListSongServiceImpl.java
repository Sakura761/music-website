package com.sakura.service.impl;

import com.sakura.dao.ListSongDao;
import com.sakura.domain.ListSong;
import com.sakura.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSongServiceImpl implements ListSongService {
    @Autowired
    ListSongDao listSongDao;
    @Override
    public List<ListSong> getListSongOfSongId(int songListId) {
       return listSongDao.getListSongOfSongId(songListId);
    }
}
