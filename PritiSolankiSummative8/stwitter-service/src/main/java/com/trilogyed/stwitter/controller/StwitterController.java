package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        System.out.println("Create NOT FROM CACHE");
   //     return service.savePosts(postCommentViewModel);
        return null;
    }






}
