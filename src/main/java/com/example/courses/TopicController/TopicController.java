package com.example.courses.TopicController;

import com.example.courses.Models.Topic;
import com.example.courses.Services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {
    @Autowired //injecting the declared dependency.
    private TopicService topicService;
    /**Method to get all topics**/
    @RequestMapping(path = "/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics(); //we are calling the service via the injected topicService object.
    }

    /**Method to get a topic filtered by an ID**/
    @RequestMapping(path = "/topics/{id}") //{ } explains that it is a variable portion.
    public @ResponseBody
    Topic getTopic(@PathVariable String id){
        //pathvariable tells that the parameter we have the is the parameter for {}
        return topicService.getTopic(id);
    }

    /**Method to add a topic to the list.**/
    @PostMapping(path = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    /**Method to update a topic based on its ID**/
    @PutMapping(path = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic , @PathVariable String id){
        topicService.updateTopic(topic,id);
    }


    /**Method to delete a topic based on its ID**/
    @DeleteMapping(path = "/topics/{id}") //{ } explains that it is a variable portion.
    public @ResponseBody
    void deleteTopic(@PathVariable String id){
        //pathvariable tells that the parameter we have the is the parameter for {}
         topicService.removeTopic(id);
    }
}
