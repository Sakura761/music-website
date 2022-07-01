package com.sakura.controller;

import com.sakura.Result.Result;
import com.sakura.constants.Constants;
import com.sakura.domain.Song;
import com.sakura.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import java.util.List;

@RestController
public class SongController {

    @Autowired
    SongService songService;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 文件最大10M,DataUnit提供5中类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(20, DataUnit.MEGABYTES));
        // 设置总上传数据总大小10M
        factory.setMaxRequestSize(DataSize.of(20, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/songPic/**")
                    .addResourceLocations(Constants.SONG_PIC_PATH);
            registry.addResourceHandler("/song/**")
                    .addResourceLocations(Constants.SONG_PATH);
        }
    }

    /**
     * 歌手详情
     * @param singerId
     * @return
     */
    @GetMapping("/song/singer/detail")
    public Result getSongBySingerId(int singerId) {
        return new Result(200,"success",true,null,songService.getSongBySingerId(singerId));
    }

    @GetMapping("/song/singerName/detail")
    public Result getSongBySingerName(String name) {
        return new Result(200,"success",true,null,songService.getSongBySingerName(name));
    }

    @GetMapping("/song/detail")
    public Result getSongById(int id) {
        List<Song> songs = songService.getSongById(id);
        return new Result(200,"success",true,null,songs);
    }

}
