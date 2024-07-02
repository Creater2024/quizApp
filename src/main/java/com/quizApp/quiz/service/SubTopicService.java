package com.quizApp.quiz.service;

import com.quizApp.quiz.requestWrapper.SubTopicRequestWrapper;
import org.springframework.stereotype.Service;

@Service
public interface SubTopicService {
    void createSubTopic(SubTopicRequestWrapper requestWrapper);
}
