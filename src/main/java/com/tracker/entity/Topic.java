package com.tracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Topic name cannot be empty")
    @Column(nullable = false)
    private String topicName;

    // "Completed" or "Not Completed"
    private String status;

    public Topic() {
        this.status = "Not Completed"; // default status
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTopicName() { return topicName; }
    public void setTopicName(String topicName) { this.topicName = topicName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
