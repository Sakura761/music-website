package com.sakura.dao;

import com.sakura.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {
    List<Comment> getCommentBySongId(int songId);
    int updateComment(Comment comment);
    int addComment(Comment comment);
    List<Comment> getCommentBySongListId(int songListId);
    int deleteComment(int id);
}
