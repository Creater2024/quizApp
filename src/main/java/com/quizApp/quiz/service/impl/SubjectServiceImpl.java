package com.quizApp.quiz.service.impl;

import com.quizApp.quiz.domain.Subject;
import com.quizApp.quiz.repository.SubjectRepository;
import com.quizApp.quiz.requestWrapper.SubjectRequestWrapper;
import com.quizApp.quiz.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }


    @Override
    public void createSubject(SubjectRequestWrapper requestWrapper){
      Subject subject = new Subject();
      subject.setName(requestWrapper.getName());
      subjectRepository.save(subject);
  }
}
