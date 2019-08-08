package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentServiceController {

    @Autowired
    CommentDao commentDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody @Valid Comment comment) {

        return commentDao.addComment(comment);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment getComment(@PathVariable("id") int commentId) {
        Comment comment = commentDao.getComment(commentId);
        if (comment == null)
            throw new IllegalArgumentException("Comment does not exist for id " + commentId);
        return comment;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComments() {
        return commentDao.getAllComments();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("id") int commentId) {

        commentDao.deleteComment(commentId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable("id") int commentId, @RequestBody @Valid Comment comment) {
        if (comment.getCommentId() == 0)
            comment.setCommentId(commentId);
        if (commentId != comment.getCommentId()) {
            throw new IllegalArgumentException("Comment ID provided not available");
        }
        commentDao.updateComment(comment);
    }
}
