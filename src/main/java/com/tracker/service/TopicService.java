package com.tracker.service;

import com.tracker.entity.Topic;
import com.tracker.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    // Constructor injection (recommended over @Autowired on field)
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    /** Returns all topics from the database */
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    /** Saves a new topic (status defaults to "Not Completed" via entity constructor) */
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    /** Marks a topic as "Completed" by its id */
    public void markCompleted(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found: " + id));
        topic.setStatus("Completed");
        topicRepository.save(topic);
    }

    /** Deletes a topic by its id */
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
