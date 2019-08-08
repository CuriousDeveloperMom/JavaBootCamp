package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.util.feign.ServiceClientComment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


}
