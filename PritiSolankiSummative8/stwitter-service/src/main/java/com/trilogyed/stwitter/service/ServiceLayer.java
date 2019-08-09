package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.ServiceClientComment;
import com.trilogyed.stwitter.util.feign.ServiceClientPost;
import com.trilogyed.stwitter.viewModel.CommentViewModel;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    @Autowired
    ServiceClientComment serviceClientComment;

    @Autowired
    ServiceClientPost serviceClientPost;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY_FOR_LIST_OF_OBJECTS = "comment.create.list.obj";


    public ServiceLayer() {
    }

    public ServiceLayer(ServiceClientComment serviceClientComment, ServiceClientPost serviceClientPost)
    {
        this.serviceClientPost = serviceClientPost;
        this.serviceClientComment = serviceClientComment;
    }

    public ServiceLayer(ServiceClientComment serviceClientComment, ServiceClientPost serviceClientPost,  RabbitTemplate rabbitTemplate)
    {
        this.serviceClientPost = serviceClientPost;
        this.serviceClientComment = serviceClientComment;
        this.rabbitTemplate = rabbitTemplate;
    }

    public PostViewModel buildPostViewModel(Post post)
    {
        PostViewModel pvm = new PostViewModel();
        pvm.setPostID(post.getPostID());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());
        pvm.setPost(post.getPost());

        List<Comment> commentList = serviceClientComment.getCommentByPostId(post.getPostID());
        List<CommentViewModel> cvmList = new ArrayList<>();
        for (Comment comment : commentList)
        {
            CommentViewModel cvm = new CommentViewModel();
            cvm.setCreateDate(comment.getCreateDate());
            cvm.setCommenterName(comment.getCommenterName());
            cvm.setComment(comment.getComment());
            cvmList.add(cvm);
        }
        pvm.setcList(cvmList);

        return pvm;
    }


    @Transactional
    public PostViewModel savePost(PostViewModel postViewModel)
    {
        Post post = new Post();
        post.setPostDate(postViewModel.getPostDate());
        post.setPosterName(postViewModel.getPosterName());
        post.setPost(postViewModel.getPost());

        post = serviceClientPost.createPost(post);
        postViewModel.setPostID(post.getPostID());

        List<Comment> commentList = new ArrayList<>();
        List<CommentViewModel> cvmList = new ArrayList<>();

        postViewModel.getcList().stream().
                forEach(c ->
                {
                    Comment comment = new Comment();
                    comment.setPostId(postViewModel.getPostID());
                    comment.setCreateDate(c.getCreateDate());
                    comment.setCommenterName(c.getCommenterName());
                    comment.setComment(c.getComment());
                    commentList.add(comment);

                    CommentViewModel commentViewModel = new CommentViewModel();
                    commentViewModel.setCreateDate(c.getCreateDate());
                    commentViewModel.setCommenterName(c.getCommenterName());
                    commentViewModel.setComment(c.getComment());
                    cvmList.add(commentViewModel);
                });

            try {
                rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_FOR_LIST_OF_OBJECTS, commentList);
            }
            catch (NullPointerException e)
            {
                postViewModel.setcList(cvmList);
                return postViewModel;
            }

            return postViewModel;
        }

    public List<PostViewModel> getAllPosts()
    {
        List<Post> postList = serviceClientPost.getAllPosts();
        List<Comment> commentList = serviceClientComment.getAllComments();
        List<PostViewModel> pvmList = new ArrayList<>();

        for (Post post : postList)
        {
            PostViewModel pcvm = buildPostViewModel(post);
            pvmList.add(pcvm);
        }
        return pvmList;
    }

    public PostViewModel getPostByPostId(int id)
    {
        try {
            Post post = serviceClientPost.getPostById(id);
            List<Comment> commentList = serviceClientComment.getCommentByPostId(post.getPostID());

            PostViewModel pvm = new PostViewModel();
            pvm.setPostID(post.getPostID());
            pvm.setPostDate(post.getPostDate());
            pvm.setPosterName(post.getPosterName());
            pvm.setPost(post.getPost());

            List<CommentViewModel> cvmList = new ArrayList<>();
            for (Comment comment : commentList) {
                CommentViewModel cvm = new CommentViewModel();
                cvm.setCreateDate(comment.getCreateDate());
                cvm.setCommenterName(comment.getCommenterName());
                cvm.setComment(comment.getComment());
                cvmList.add(cvm);
            }
            pvm.setcList(cvmList);
            return pvm;
        }
        catch (NullPointerException e)
        {
            return null;
        }
    }

    public List<PostViewModel> getPostByPoster(String posterName)
    {
        List<Post> postList = serviceClientPost.getPostsByPoster(posterName);
        List<PostViewModel> pvmList = new ArrayList<>();

        for (Post post : postList)
        {
            PostViewModel pvm = buildPostViewModel(post);
            pvmList.add(pvm);
        }
        return pvmList;
    }

    @Transactional
    public void updatePostViewModel(PostViewModel postViewModel)
    {
        Post post = new Post();
        post.setPostID(postViewModel.getPostID());
        post.setPostDate(postViewModel.getPostDate());
        post.setPosterName(postViewModel.getPosterName());
        post.setPost(postViewModel.getPost());

        serviceClientPost.updatePost(post, post.getPostID());

        List<CommentViewModel> cvmList = postViewModel.getcList();

        List<Comment> commentList = new ArrayList<>();
        for (CommentViewModel cvm : cvmList)
        {
            Comment comment = new Comment();
            comment.setPostId(post.getPostID());
            comment.setCreateDate(cvm.getCreateDate());
            comment.setCommenterName(cvm.getCommenterName());
            comment.setComment(cvm.getComment());
            commentList.add(comment);
        }
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_FOR_LIST_OF_OBJECTS, commentList);
    }

    @Transactional
    public void deletePostViewModel(int id)
    {
        // In order to remove Post, You need to remove all associated comments entries.
        List<Comment> commentList = serviceClientComment.getCommentByPostId(id);
        for (Comment comment : commentList)
        {
            serviceClientComment.deleteComment(comment.getCommentId());
        }

        // Now you remove Post entries
        serviceClientPost.deletePost(id);
    }

}
