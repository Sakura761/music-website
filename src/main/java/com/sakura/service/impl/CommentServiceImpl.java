package com.sakura.service.impl;

import com.sakura.dao.CommentDao;
import com.sakura.domain.Comment;
import com.sakura.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public List<Comment> getCommentBySongId(int songId) {
        return commentDao.getCommentBySongId(songId);
    }

    @Override
    public List<Comment> getCommentBySongListId(int songListId) {
        return commentDao.getCommentBySongListId(songListId);
    }

    @Override
    public boolean updateComment(Comment comment) {
        return commentDao.updateComment(comment) > 0;
    }

    @Override
    public boolean addComment(Comment comment) {
        return commentDao.addComment(comment) > 0;
    }

    @Override
    public boolean deleteComment(int id) {
        return commentDao.deleteComment(id) > 0;
    }
}
