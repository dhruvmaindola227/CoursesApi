package com.example.courses.Topics.Repository;

import com.example.courses.Topics.Models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic , String> {
    public Topic findTopicById(String id);
}
