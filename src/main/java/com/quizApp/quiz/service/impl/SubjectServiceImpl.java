package com.quizApp.quiz.service.impl;

import com.quizApp.quiz.domain.Question;
import com.quizApp.quiz.domain.Subject;
import com.quizApp.quiz.domain.Topic;
import com.quizApp.quiz.repository.SubjectRepository;
import com.quizApp.quiz.requestWrapper.SubjectRequestWrapper;
import com.quizApp.quiz.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }


    @Override
    public void createSubject(SubjectRequestWrapper requestWrapper){
        if(requestWrapper == null || requestWrapper.getName() == null ||requestWrapper.getName().trim().isEmpty()){
            throw new IllegalArgumentException("name is not found");
        }
      Subject subject = new Subject();
      subject.setName(requestWrapper.getName());
      subjectRepository.save(subject);
  }

    @Override
    public List<Topic> getAllTopics(Long subjectId) {
        List<Topic> topicList = new ArrayList<>();
        if(subjectId != null){
            Subject subject = new Subject();
            subject = subjectRepository.findById(subjectId)
                    .orElseThrow(()-> new IllegalArgumentException("Subject not found with id: " + subjectId));
            topicList = subjectRepository.findAllTopicBySubjectId(subjectId);
        }
        return topicList;
    }

    @Override
    public List<Subject> getAllSubject() {
        List<Subject> subjectList = new ArrayList<>();
        subjectList = subjectRepository.findAll();
        return subjectList;
    }
}
