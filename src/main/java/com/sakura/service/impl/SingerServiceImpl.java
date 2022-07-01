package com.sakura.service.impl;

import com.sakura.dao.SingerDao;
import com.sakura.domain.Singer;
import com.sakura.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    SingerDao singerDao;

    @Override
    public List<Singer> getAllSinger() {
        return singerDao.getAllSinger();
    }

    @Override
    public List<Singer> getSingerBySex(int sex) {
        return singerDao.getSingerBySex(sex);
    }
}
