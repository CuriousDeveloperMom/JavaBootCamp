package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
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
public class PostDaoJdbcTemplateImplTest {

    @Autowired
    protected PostDao postDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Post> pList = postDao.getAllPosts();

        pList.stream()
                .forEach(post -> postDao.deletePost(post.getPostID()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeletePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 02, 22));
        post.setPosterName("Abhi");
        post.setPost("Blah Blah Blah Blah");

        post = postDao.addPost(post);

        Post post1 = postDao.getPost(post.getPostID());
        assertEquals(post, post1);
        postDao.deletePost(post.getPostID());

        post1 = postDao.getPost(post.getPostID());
        assertNull(post1);
    }

    @Test
    public void addPost() {
    }

    @Test
    public void getPost() {
    }

    @Test
    public void getAllPosts() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 02, 22));
        post.setPosterName("Abhi");
        post.setPost("Blah Blah Blah Blah");

        postDao.addPost(post);

        post = new Post();
        post.setPostDate(LocalDate.of(2019, 02, 22));
        post.setPosterName("Abhi");
        post.setPost("Blah Blah Blah Blah");

        postDao.addPost(post);


        List<Post> posts = postDao.getAllPosts();
        assertEquals(posts.size(), 2);
    }

    @Test
    public void updatePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 02, 22));
        post.setPosterName("Abhi");
        post.setPost("Blah Blah Blah Blah");

        post = postDao.addPost(post);


        post.setPosterName("Aarya");

        postDao.updatePost(post);

        Post post1 = postDao.getPost(post.getPostID());
        assertEquals(post1, post);
    }

    @Test
    public void deletePost() {
    }

    @Test
    public void getPostsByPoster() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 02, 01));
        post.setPosterName("Abhi");
        post.setPost("Blah Blah Blah Blah");

        postDao.addPost(post);

        post = new Post();
        post.setPostDate(LocalDate.of(2019, 02, 22));
        post.setPosterName("Aarya");
        post.setPost("Blah Blah Blah Blah");

        postDao.addPost(post);

        post = new Post();
        post.setPostDate(LocalDate.of(2019, 02, 10));
        post.setPosterName("Abhi");
        post.setPost("Blah Blah Blah Blah");

        postDao.addPost(post);

        List<Post> posts = postDao.getPostsByPoster("Abhi");
        assertEquals(2, posts.size());

        posts = postDao.getPostsByPoster("Aarya");
        assertEquals(1, posts.size());


    }
}