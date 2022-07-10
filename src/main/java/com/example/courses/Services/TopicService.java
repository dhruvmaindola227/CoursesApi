package com.example.courses.Services;

import com.example.courses.Models.Topic;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    //Arrays.asList() gives an immutable list.
    private List<Topic> topicsList = new ArrayList<>(Arrays.asList(
            new Topic("spring" , "spring framework" , "spring is a BIG framework"),
            new Topic("maven" , "maven management" , "maven is a java project management system"),
            new Topic("springboot" , "springboot framework" , "springboot is a famous framework")
    ));

    @RequestMapping(path = "/topics")
    public List<Topic> getAllTopics(){
        return topicsList;
    }

    public Topic getTopic(String id){
        return topicsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        //otherwise can also do using stream api and lamda expressions.
//        for (int i = 0; i < topicsList.size(); i++) {
//            if(Objects.equals(id, topicsList.get(i).getId())){
//                return topicsList.get(i);
//            }
//        }
//        return null;
    }

    public void addTopic(Topic topic){
        topicsList.add(topic);
    }

    public void updateTopic(Topic topic , String id){
        for (int i = 0; i < topicsList.size(); i++) {
            if(topicsList.get(i).getId().equals(id)){
                topicsList.set(i , topic);
                return;
            }
        }
    }

    public void removeTopic(String id) {
        topicsList.removeIf(t -> t.getId().equals(id));
    }
}
