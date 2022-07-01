package com.sakura.controller;

import com.sakura.Result.Result;
import com.sakura.constants.Constants;
import com.sakura.domain.Consumer;
import com.sakura.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/avatorImages/**")
                    .addResourceLocations(Constants.AVATOR_IMAGES_PATH);
        }
    }

    /**
     * 功能：用户注册
     */
    @RequestMapping(value = "user/add",method = RequestMethod.POST)
    public Result addUser(@RequestBody Consumer consumer){
        String avator = "/img/avatorImages/user.jpg";
        Consumer consumer1 = consumerService.selectByUsername(consumer.getUsername());
        if(consumer1 != null) {
            return new Result(200,"warning",false,"用户已注册");
        }
        if("".equals(consumer.getPhoneNum())) {
            consumer.setPhoneNum(null);
        }
        if ("".equals(consumer.getEmail())) {
            consumer.setEmail(null);
        }
        consumer.setAvator(avator);
        consumer.setCreateTime(new Date());
        consumer.setUpdateTime(new Date());
        System.out.println(consumer);
//        consumerService.insertUser(consumer);
        return new Result(200,"success",true,"注册成功");
    }

    /**
     * 功能：验证用户登录功能
     * @param consumer
     * @param session
     * @return
     */
    @PostMapping("user/login/status")
    public Result signIn(@RequestBody Consumer consumer, HttpSession session) {
        int res = consumerService.verifyPassword(consumer.getUsername(), consumer.getPassword());
        if(res > 0) {
            session.setAttribute("username",consumer.getUsername());
            Consumer consumer1 = consumerService.selectByUsername(consumer.getUsername());
            List<Consumer> list = new ArrayList<>();
            list.add(consumer1);
            return new Result(200,"success",true,"登录成功",list);
        }
        return new Result(200,"error",false,"用户名或密码错误");
    }

    /**
     * 功能：更新用户信息
     * @param consumer
     * @return
     */
    @PostMapping("/user/update")
    public Result updateUserMsg(@RequestBody Consumer consumer) {
        if(consumerService.selectByUsername(consumer.getUsername()) != null) {
            return new Result(200,"warning",false,"用户名已被使用");
        }
        consumer.setUpdateTime(new Date());
        boolean flag = consumerService.updateUser(consumer);
        if(flag) {
            return new Result(200,"success",true,"修改成功");
        }
        return new Result(200,"error",false,"修改失败");
    }

    /**
     * 功能：按id查找用户
     * @param id
     * @return
     */
    @GetMapping("/user/detail")
    public Result getUserById(int id) {
        Consumer consumer = consumerService.getUSerById(id);
        List<Consumer> consumers = new ArrayList<>();
        consumers.add(consumer);
        return new Result(200,"success",true,null,consumers);
    }

    @PostMapping("/user/updatePassword")
    public Result updatePassword(int id,String username, String old_password, String password) {
        Consumer consumer = consumerService.getUSerById(id);
        old_password = old_password.trim();
        password = password.trim();
        if(!consumer.getPassword().equals(old_password)) {
            return new Result(200,"warning",false,"旧密码输入错误");
        }
        Consumer consumer1 = new Consumer();
        consumer1.setId(id);
        consumer1.setPassword(password);
        boolean flag = consumerService.updateUser(consumer1);
        if(flag) {
            return new Result(200,"success",true,"修改密码成功");
        }
        return new Result(200,"error",false,"修改密码失败");
    }

//    @GetMapping("/user/avatar/update")
//    public Result updateAvator(@RequestParam("id") int id,@RequestParam("file") MultipartFile avatorFile) {
//        String filename = System.currentTimeMillis() + avatorFile.getOriginalFilename();
//        String filePath = Constants.PROJECT_PATH + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "avatorImages";
//        File file1 = new File(filePath);
//        if (!file1.exists()) {
//            file1.mkdir();
//        }
//
//
//    }
    @GetMapping("/user/delete")
    public Result deleteUser(int id) {
        boolean flag = consumerService.deleteUser(id);
        if(flag) {
            return new Result(200,"success",true,"注销成功");
        } else {
            return new Result(500,"error",false,"注销失败");
        }
    }
}
