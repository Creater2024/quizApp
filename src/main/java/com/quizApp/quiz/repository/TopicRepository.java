package com.quizApp.quiz.repository;

import com.quizApp.quiz.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Long> {
}
