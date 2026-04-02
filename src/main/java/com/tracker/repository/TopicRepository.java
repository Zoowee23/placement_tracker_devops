package com.tracker.repository;

import com.tracker.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository gives us save, findAll, findById, deleteById, etc. for free
@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
