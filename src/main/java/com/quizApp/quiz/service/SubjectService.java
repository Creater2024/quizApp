package com.quizApp.quiz.service;

import com.quizApp.quiz.requestWrapper.SubjectRequestWrapper;
import org.springframework.stereotype.Service;

@Service
public interface SubjectService {
     void createSubject(SubjectRequestWrapper requestWrapper);
}
