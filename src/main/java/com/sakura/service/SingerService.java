package com.sakura.service;

import com.sakura.domain.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> getAllSinger();
    List<Singer> getSingerBySex(int sex);
}
