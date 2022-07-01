package com.sakura.dao;

import com.sakura.domain.RankList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RankListDao {
    int setRank(RankList rankList);
}
