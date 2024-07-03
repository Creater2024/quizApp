package com.quizApp.quiz.service.impl;

import com.quizApp.quiz.domain.SubTopic;
import com.quizApp.quiz.domain.Subject;
import com.quizApp.quiz.domain.Topic;
import com.quizApp.quiz.repository.SubTopicRepository;
import com.quizApp.quiz.repository.SubjectRepository;
import com.quizApp.quiz.repository.TopicRepository;
import com.quizApp.quiz.requestWrapper.SubTopicRequestWrapper;
import com.quizApp.quiz.service.SubTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTopicServiceImpl implements SubTopicService {
    private final SubTopicRepository subTopicRepository;
    private final TopicRepository topicRepository;
    private final SubjectRepository subjectRepository;
    @Autowired
    public SubTopicServiceImpl(SubTopicRepository subTopicRepository ,TopicRepository topicRepository,SubjectRepository subjectRepository){
        this.subTopicRepository = subTopicRepository;
        this.topicRepository = topicRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void createSubTopic(SubTopicRequestWrapper requestWrapper){
        Topic topic = topicRepository.findById(requestWrapper.getTopicId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Topic ID: " + requestWrapper.getTopicId()));
        SubTopic subTopic = new SubTopic();
        subTopic.setName(requestWrapper.getSubTopicName());
        subTopic.setTopicId(requestWrapper.getTopicId());
        subTopic.setSubjectId(topic.getSubjectId());
        subTopicRepository.save(subTopic);
    }
}
