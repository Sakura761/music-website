package com.sakura.controller;

import com.sakura.Result.Result;
import com.sakura.domain.Comment;
import com.sakura.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/comment/song/detail")
    public Result getCommentBySongId(int songId) {
        return new Result(200,"success",true,null,commentService.getCommentBySongId(songId));
    }
    @GetMapping("/comment/songList/detail")
    public Result getCommentBySongListId(int songListId) {
        List<Comment> comments = commentService.getCommentBySongListId(songListId);
        return new Result(200,"success",true,null,comments);
    }
    @PostMapping("/comment/like")
    public Result setSupport(int id, int up){
        Comment comment = new Comment();
        System.out.println(id);
        System.out.println(up);
        comment.setId(id);
        comment.setUp(up);
        boolean flag = commentService.updateComment(comment);
        System.out.println(flag);
        if(flag) {
            return new Result(200,"success",true,"点赞成功");
        } else {
            return new Result(500,"error",false,"点赞失败");
        }
    }
    @PostMapping("/comment/add")
    public Result addComment(Comment comment) {
        comment.setCreateTime(new Date());
        boolean flag = commentService.addComment(comment);
        if(flag) {
            return new Result(200,"success",true,"评论成功");
        } else {
            return new Result(500,"error",false,"评论失败");
        }
    }

    @GetMapping("/comment/delete")
    public Result deleteComment(int id) {
        boolean flag = commentService.deleteComment(id);
        if(flag) {
            return new Result(200,"success",true,"删除成功");
        } else {
            return new Result(500,"error",false,"删除失败");
        }
    }
}
