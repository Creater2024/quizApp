package com.quizApp.quiz.service.impl;

import com.quizApp.quiz.domain.Subject;
import com.quizApp.quiz.repository.SubjectRepository;
import com.quizApp.quiz.repository.TopicRepository;
import com.quizApp.quiz.requestWrapper.TopicRequestWrapper;
import com.quizApp.quiz.domain.Topic;
import com.quizApp.quiz.service.SubTopicService;
import com.quizApp.quiz.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository,SubjectRepository subjectRepository){
        this.topicRepository = topicRepository;
        this.subjectRepository = subjectRepository;
    }

    public void createTopic(TopicRequestWrapper requestWrapper){
        Subject subject = subjectRepository.findById(requestWrapper.getSubjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID"));
        Topic topic = new Topic();
        topic.setName(requestWrapper.getTopicName());
        topic.setSubjectId(requestWrapper.getSubjectId());
        topicRepository.save(topic);
    }
}
