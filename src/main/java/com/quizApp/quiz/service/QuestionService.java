package com.quizApp.quiz.service;

import com.quizApp.quiz.requestWrapper.QuestionRequestWrapper;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {
    void createQuestion(QuestionRequestWrapper requestWrapper);
}
