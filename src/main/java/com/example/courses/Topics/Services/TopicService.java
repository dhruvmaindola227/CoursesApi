package com.example.courses.Topics.Services;

import com.example.courses.Topics.Models.Topic;
import com.example.courses.Topics.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
        return this.topicRepository.findAll();
    }

    public Topic getTopic(String id){
        return this.topicRepository.findTopicById(id);
    }

    public void addTopic(Topic topic){
        this.topicRepository.save(topic);
    }

    public void updateTopic(Topic topic , String id){
        this.topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        this.topicRepository.deleteById(id);
    }
}
