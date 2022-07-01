package com.sakura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.sakura.*","com.sakura.dao"})
public class MusicServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicServiceApplication.class, args);
    }

}
