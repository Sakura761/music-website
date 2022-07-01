package com.sakura.service;

import com.sakura.domain.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> getCommentBySongId(int songId);
    List<Comment> getCommentBySongListId(int songListId);
    boolean updateComment(Comment comment);
    boolean addComment(Comment comment);
    boolean deleteComment(int id);
}
