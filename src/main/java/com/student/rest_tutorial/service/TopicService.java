package com.student.rest_tutorial.service;

import com.student.rest_tutorial.models.Topic;
import com.student.rest_tutorial.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getAllTopics (){
        List <Topic>topics=new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic (String id){
        return topicRepository.findById(id).get();
    }

    public Topic createTopic (Topic topic){
        return topicRepository.save(topic);
    }

    public Topic updateTopic (String id,Topic topic){
        return topicRepository.save(topic);
    }

    public void deleteTopic (String id){
         topicRepository.deleteById(id);
    }

    public List<Topic> pagination(int size, int page){
        List<Topic>lista=topicRepository.findAll();
        List<Topic>nenlist=new ArrayList<>(lista.subList(size, page));
                return nenlist;

    }
}
