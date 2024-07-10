package com.quizApp.quiz.service.impl;

import com.quizApp.quiz.domain.SubTopic;
import com.quizApp.quiz.domain.Subject;
import com.quizApp.quiz.repository.SubjectRepository;
import com.quizApp.quiz.repository.TopicRepository;
import com.quizApp.quiz.requestWrapper.TopicRequestWrapper;
import com.quizApp.quiz.domain.Topic;
import com.quizApp.quiz.service.SubTopicService;
import com.quizApp.quiz.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository,SubjectRepository subjectRepository){
        this.topicRepository = topicRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void createTopic(TopicRequestWrapper requestWrapper){
        if(requestWrapper == null || requestWrapper.getTopicName() == null || requestWrapper.getTopicName().trim().isBlank()){
            throw new IllegalArgumentException("topic name is not found");
        }
        Subject subject = subjectRepository.findById(requestWrapper.getSubjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID"));
        Topic topic = new Topic();
        topic.setName(requestWrapper.getTopicName());
        topic.setSubjectId(requestWrapper.getSubjectId());
        topicRepository.save(topic);
    }

    @Override
    public List<SubTopic> getAllSubTopics(Long topicId) {
        List<SubTopic> subTopicList = new ArrayList<>();
        if(topicId != null){
            Topic topic = new Topic();
            topic = topicRepository.findById(topicId)
                    .orElseThrow(()-> new IllegalArgumentException("Topic not found with id: " + topicId));
            subTopicList = topicRepository.findAllSubTopicByTopic(topicId);
        }
        return subTopicList;
    }

}
