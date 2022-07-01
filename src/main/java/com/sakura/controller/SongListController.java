package com.sakura.controller;

import com.sakura.Result.Result;
import com.sakura.constants.Constants;
import com.sakura.domain.SongList;
import com.sakura.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
public class SongListController {
    @Autowired
    SongListService songListService;
    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/songListPic/**")
                    .addResourceLocations(Constants.SONGLIST_PIC_PATH);
        }
    }
    @GetMapping("/songList")
    public Result getSongList() {
        return new Result(200,"success",true,null,songListService.getSongList());
    }
    @GetMapping("/songList/style/detail")
    public Result getSongListByStyle(String style) {
        List<SongList> songListByStyle = songListService.getSongListByStyle(style);
        return new Result(200,"success",true,null,songListByStyle);
    }
}
