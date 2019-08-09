package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@CacheConfig(cacheNames = {"posts"})
public class StwitterController {


    ServiceLayer service;

    @Autowired
    public StwitterController(ServiceLayer service) {
        this.service = service;
    }

    @CachePut(key = "#result.postID")
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public PostViewModel createPost(@RequestBody @Valid PostViewModel postViewModel)
    {
        System.out.println("NOT CREATING FROM CACHE MEMORY");
        return service.savePost(postViewModel);
    }

    @Cacheable
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getAllPost()
    {
        System.out.println("NOT GETTING FROM CACHE MEMORY");
        return service.getAllPosts();
    }

    @Cacheable
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel getPostByPostId(@PathVariable int id)
    {
        System.out.println("GETTING POSTS BY ID NOT FROM CACHE MEMORY");
        return service.getPostByPostId(id);
    }

    @Cacheable
    @RequestMapping(value = "/posts/user/{posterName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getpostByPoster(@PathVariable("posterName") String posterName)
    {
        System.out.println("GETTING POSTS BY POSTER NOT FROM CACHE MEMORY");
        return service.getPostByPoster(posterName);
    }

}
