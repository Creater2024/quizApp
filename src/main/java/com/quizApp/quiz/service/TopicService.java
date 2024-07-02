package com.quizApp.quiz.service;


import com.quizApp.quiz.requestWrapper.TopicRequestWrapper;
import org.springframework.stereotype.Service;

@Service
public interface TopicService {
    void createTopic(TopicRequestWrapper requestWrapper);
}
