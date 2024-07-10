package com.quizApp.quiz.service;


import com.quizApp.quiz.domain.SubTopic;
import com.quizApp.quiz.requestWrapper.TopicRequestWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicService {
    void createTopic(TopicRequestWrapper requestWrapper);
    List<SubTopic> getAllSubTopics(Long topicId);
}
