package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;

import java.util.List;

public interface PostDao {

    Post addPost(Post post);

    Post getPost(int postId);

    List<Post> getAllPosts();

    Post updatePost(Post post);

    void deletePost(int postId);

    List<Post> getPostsByPoster(String posterName);

}
