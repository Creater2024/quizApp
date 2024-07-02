package com.quizApp.quiz.service.impl;

import com.quizApp.quiz.repository.TopicRepository;
import com.quizApp.quiz.requestWrapper.TopicRequestWrapper;
import com.quizApp.quiz.domain.Topic;
import com.quizApp.quiz.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository){
        this.topicRepository = topicRepository;
    }

    public void createTopic(TopicRequestWrapper requestWrapper){
        Topic topic = new Topic();
        topic.setName(requestWrapper.getTopicName());
        topicRepository.save(topic);
    }
}
