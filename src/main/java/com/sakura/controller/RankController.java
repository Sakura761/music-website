package com.sakura.controller;

import com.sakura.Result.Result;
import com.sakura.domain.RankList;
import com.sakura.service.RankListService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankController {
    @Autowired
    private RankListService rankListService;
    @PostMapping("rankList/add")
    Result setRank(@Param("songListId") long songListId, @Param("consumerId") long consumerId, @Param("score") Integer score) {
        RankList rankList = new RankList();
        rankList.setConsumerId(consumerId);
        rankList.setSongListId(songListId);
        rankList.setScore(score);
        boolean flag = rankListService.setRank(rankList);
        if(flag) {
            return new Result(200,"success",true,"评价成功");
        } else {
            return new Result(500,"error",false,"评价失败");
        }
    }
}
