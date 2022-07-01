package com.sakura.service.impl;

import com.sakura.dao.RankListDao;
import com.sakura.domain.RankList;
import com.sakura.service.RankListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankListServiceImpl implements RankListService {
    @Autowired
    private RankListDao rankListDao;
    @Override
    public boolean setRank(RankList rankList) {
        return  rankListDao.setRank(rankList) > 0;
    }
}
