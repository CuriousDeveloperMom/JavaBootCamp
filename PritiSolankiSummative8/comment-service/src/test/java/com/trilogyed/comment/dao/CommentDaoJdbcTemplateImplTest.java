package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentDaoJdbcTemplateImplTest {

    @Autowired
    protected CommentDao commentDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Comment> cList = commentDao.getAllComments();

        cList.stream()
                .forEach(comment -> commentDao.deleteComment(comment.getCommentId()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteComment() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,04,10));
        comment.setCommenterName("Abhishek");
        comment.setComment("Blah Blah Blah Blah");

        comment = commentDao.addComment(comment);
        Comment comment1 = commentDao.getComment(comment.getCommentId());
        assertEquals(comment, comment1);
        commentDao.deleteComment(comment.getCommentId());

        comment1 = commentDao.getComment(comment.getCommentId());
        assertNull(comment1);
    }

    @Test
    public void addComment() {
    }

    @Test
    public void getComment() {
    }

    @Test
    public void getAllComments() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,04,10));
        comment.setCommenterName("Abhishek");
        comment.setComment("Blah Blah Blah Blah");

        commentDao.addComment(comment);

        comment = new Comment();
        comment.setPostId(2);
        comment.setCreateDate(LocalDate.of(2019,05,15));
        comment.setCommenterName("Aaryaman");
        comment.setComment("Blah Blah Blah Blah");
        commentDao.addComment(comment);

        List<Comment> cList = commentDao.getAllComments();
        assertEquals(cList.size(), 2);
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,04,10));
        comment.setCommenterName("Abhishek");
        comment.setComment("Blah Blah Blah Blah");

        comment = commentDao.addComment(comment);

        comment.setCreateDate(LocalDate.of(2019,05,15));
        comment.setCommenterName("Aaryaman");
        comment.setComment("Blah Blah Blah Blah");
        commentDao.updateComment(comment);

        Comment comment1 = commentDao.getComment(comment.getCommentId());
        assertEquals(comment1, comment);
    }

    @Test
    public void deleteComment() {
    }
}