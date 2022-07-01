package com.sakura.domain;

import java.util.Date;

public class Collect {
    private Integer id;
    private Integer user_id;
    private Byte type;
    private Integer songId;
    private Integer songListId;
    private Date createTime;

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", type=" + type +
                ", songId=" + songId +
                ", songListId=" + songListId +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getSongListId() {
        return songListId;
    }

    public void setSongListId(Integer songListId) {
        this.songListId = songListId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
