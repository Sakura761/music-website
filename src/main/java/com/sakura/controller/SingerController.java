package com.sakura.controller;

import com.sakura.Result.Result;
import com.sakura.constants.Constants;
import com.sakura.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
public class SingerController {
    @Autowired
    SingerService singerService;
    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/singerPic/**")
                    .addResourceLocations(Constants.SINGER_PIC_PATH);
        }
    }
    @GetMapping("/singer")
    public Object getAllSinger() {
        return new Result(200,"success",true,null,singerService.getAllSinger());
    }
    @GetMapping("/singer/sex/detail")
    public Result getSingerBySex(int sex) {
        return new Result(200,"success",true,null,singerService.getSingerBySex(sex));
    }
}
