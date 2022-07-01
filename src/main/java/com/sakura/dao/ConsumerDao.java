package com.sakura.dao;

import com.sakura.domain.Consumer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ConsumerDao {
    //@Insert("insert into consumer values(null,#{username},#{password},#{sex},#{phoneNum},#{email},#{birth},#{introduction},#{location},#{avator},#{createTime},#{updateTime})")
    int addUser(Consumer consumer);
    Consumer selectByUsername(String username);
    int verifyPassword(@Param("username") String username, @Param("password") String password);
    int updateUser(Consumer consumer);
    Consumer getUserById(int id);
    int deleteUser(int id);
}
