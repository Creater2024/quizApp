package com.quizApp.quiz.service;

import com.quizApp.quiz.domain.Subject;
import com.quizApp.quiz.domain.Topic;
import com.quizApp.quiz.requestWrapper.SubjectRequestWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
     void createSubject(SubjectRequestWrapper requestWrapper);
     List<Topic> getAllTopics(Long subjectId);
     List<Subject> getAllSubject();
}
