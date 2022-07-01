package com.sakura.controller;

import com.sakura.Result.Result;
import com.sakura.domain.ListSong;
import com.sakura.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListSongController {
    @Autowired
    ListSongService listSongService;
    @GetMapping("/listSong/detail")
    public Result getListSongOfSongId(int songListId) {
        List<ListSong> listSongOfSongId = listSongService.getListSongOfSongId(songListId);
        return new Result(200,"success",true,null,listSongOfSongId);
    }
}
