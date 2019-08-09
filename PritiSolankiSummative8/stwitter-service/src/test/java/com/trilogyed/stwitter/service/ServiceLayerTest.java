package com.trilogyed.stwitter.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.ServiceClientComment;
import com.trilogyed.stwitter.util.feign.ServiceClientPost;
import com.trilogyed.stwitter.viewModel.CommentViewModel;
import com.trilogyed.stwitter.viewModel.PostViewModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;

public class ServiceLayerTest {

    ServiceClientPost serviceClientPost;
    ServiceClientComment serviceClientComment;
    ServiceLayer serviceLayer;


    @Before
    public void setUp() throws Exception {

        setUpServiceClientPost();
        setUpServiceClientComment();
        serviceLayer = new ServiceLayer(serviceClientComment, serviceClientPost);
    }

    @After
    public void tearDown() throws Exception {
    }

    private void setUpServiceClientPost()
    {
        serviceClientPost = mock(ServiceClientPost.class);

        Post postToFeignClient = new Post();

        postToFeignClient.setPostDate(LocalDate.of(2019, 11, 10));
        postToFeignClient.setPosterName("Abhi");
        postToFeignClient.setPost("Its all about Football");

        Post postFromFeignClient = new Post();

        postFromFeignClient.setPostID(1);
        postFromFeignClient.setPostDate(LocalDate.of(2019, 11, 10));
        postFromFeignClient.setPosterName("Abhi");
        postFromFeignClient.setPost("Its all about Football");

        List<Post> pList = new ArrayList<>();
        pList.add(postFromFeignClient);

        doReturn(postFromFeignClient).when(serviceClientPost).createPost(postToFeignClient);
        doReturn(postFromFeignClient).when(serviceClientPost).getPostById(1);
        doReturn(pList).when(serviceClientPost).getAllPosts();
        doReturn(pList).when(serviceClientPost).getPostsByPoster("Abhi");
    }

    private void setUpServiceClientComment()
    {
        serviceClientComment = mock(ServiceClientComment.class);

        Comment commentToFeignClient = new Comment();

        commentToFeignClient.setPostId(1);
        commentToFeignClient.setCreateDate(LocalDate.of(2019, 11, 10));
        commentToFeignClient.setCommenterName("Aarya");
        commentToFeignClient.setComment("Its all about SuperBall");

        Comment commentFromFeignClient = new Comment();

        commentFromFeignClient.setCommentId(1);
        commentFromFeignClient.setPostId(1);
        commentFromFeignClient.setCreateDate(LocalDate.of(2019, 11, 10));
        commentFromFeignClient.setCommenterName("Aarya");
        commentFromFeignClient.setComment("Its all about SuperBall");

        List<Comment> cList = new ArrayList<>();
        cList.add(commentFromFeignClient);

        doReturn(commentFromFeignClient).when(serviceClientComment).createComment(commentToFeignClient);
        doReturn(commentFromFeignClient).when(serviceClientComment).getCommentByCommentId(1);
        doReturn(cList).when(serviceClientComment).getAllComments();
        doReturn(cList).when(serviceClientComment).getCommentByPostId(1);
    }

    @Test
    public void savePost() {

        PostViewModel postToFeignClient = new PostViewModel();

        postToFeignClient.setPostDate(LocalDate.of(2019, 11, 10));
        postToFeignClient.setPosterName("Abhi");
        postToFeignClient.setPost("Its all about Football");

        CommentViewModel commentFromFeignClient = new CommentViewModel();

        commentFromFeignClient.setCreateDate(LocalDate.of(2019, 11, 10));
        commentFromFeignClient.setCommenterName("Aarya");
        commentFromFeignClient.setComment("Its all about SuperBall");

        postToFeignClient.addComment(commentFromFeignClient);
        postToFeignClient = serviceLayer.savePost(postToFeignClient);

        PostViewModel fromService = serviceLayer.getPostByPostId(1);
        assertEquals(fromService, postToFeignClient);
    }

    @Test
    public void getAllPosts() {

        PostViewModel postToFeignClient = new PostViewModel();

        postToFeignClient.setPostDate(LocalDate.of(2019, 11, 10));
        postToFeignClient.setPosterName("Abhi");
        postToFeignClient.setPost("Its all about Football");

        CommentViewModel commentFromFeignClient = new CommentViewModel();

        commentFromFeignClient.setCreateDate(LocalDate.of(2019, 11, 10));
        commentFromFeignClient.setCommenterName("Aarya");
        commentFromFeignClient.setComment("Its all about SuperBall");

        postToFeignClient.addComment(commentFromFeignClient);

        postToFeignClient = serviceLayer.savePost(postToFeignClient);

        List<PostViewModel> pvmList= serviceLayer.getAllPosts();

        assertEquals(1, pvmList.size());
    }

    @Test
    public void getPostByPostId() {

        PostViewModel postToFeignClient = new PostViewModel();

        postToFeignClient.setPostDate(LocalDate.of(2019, 11, 10));
        postToFeignClient.setPosterName("Abhi");
        postToFeignClient.setPost("Its all about Football");

        CommentViewModel commentFromFeignClient = new CommentViewModel();

        commentFromFeignClient.setCreateDate(LocalDate.of(2019, 11, 10));
        commentFromFeignClient.setCommenterName("Aarya");
        commentFromFeignClient.setComment("Its all about SuperBall");

        postToFeignClient.addComment(commentFromFeignClient);

        postToFeignClient = serviceLayer.savePost(postToFeignClient);

        PostViewModel pvm = serviceLayer.getPostByPostId(1);
        assertEquals(pvm, postToFeignClient);
    }

    @Test
    public void getPostByPoster() {

        PostViewModel postToFeignClient = new PostViewModel();

        postToFeignClient.setPostDate(LocalDate.of(2019, 11, 10));
        postToFeignClient.setPosterName("Abhi");
        postToFeignClient.setPost("Its all about Football");

        CommentViewModel commentFromFeignClient = new CommentViewModel();

        commentFromFeignClient.setCreateDate(LocalDate.of(2019, 11, 10));
        commentFromFeignClient.setCommenterName("Aarya");
        commentFromFeignClient.setComment("Its all about SuperBall");

        postToFeignClient.addComment(commentFromFeignClient);

        postToFeignClient = serviceLayer.savePost(postToFeignClient);

        List<PostViewModel> pvmList = serviceLayer.getPostByPoster("Abhi");
        assertEquals(1, pvmList.size());

        pvmList = serviceLayer.getPostByPoster("Aarya");
        assertEquals(0, pvmList.size());
    }

    @Test
    public void updatePostViewModel() {
    }

    @Test
    public void deletePostViewModel() {
    }
}