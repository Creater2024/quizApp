package com.quizApp.quiz.service.impl;

import com.quizApp.quiz.domain.SubTopic;
import com.quizApp.quiz.repository.SubTopicRepository;
import com.quizApp.quiz.requestWrapper.SubTopicRequestWrapper;
import com.quizApp.quiz.service.SubTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTopicServiceImpl implements SubTopicService {
    private final SubTopicRepository subTopicRepository;

    @Autowired
    public SubTopicServiceImpl(SubTopicRepository subTopicRepository){
        this.subTopicRepository = subTopicRepository;
    }

    @Override
    public void createSubTopic(SubTopicRequestWrapper requestWrapper){
        SubTopic subTopic = new SubTopic();
        subTopic.setName(requestWrapper.getSubTopicName());
        subTopicRepository.save(subTopic);
    }
}
