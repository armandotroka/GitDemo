package com.student.rest_tutorial.controller;

import com.student.rest_tutorial.models.Topic;
import com.student.rest_tutorial.service.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAll(){
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public Topic getTopicById (@PathVariable("id") String id){
        return topicService.getTopic(id);
    }

    @PostMapping("/post")
    public Topic postTopic (@RequestBody Topic topic){
        return topicService.createTopic(topic);
    }

    @PutMapping("/update/{id}")
    public Topic updateTopic (@PathVariable("id")String id, @RequestBody Topic topic){
        return  topicService.updateTopic(id,topic);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTopic (@PathVariable("id") String id){
        topicService.deleteTopic(id);
    }

    @GetMapping("pagination")
    public List<Topic> pagination(@RequestParam("page")int page, @RequestParam("size") int size){
        return topicService.pagination(page, size);
    }
}
