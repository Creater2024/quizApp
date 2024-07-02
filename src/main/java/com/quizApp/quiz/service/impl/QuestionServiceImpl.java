package com.quizApp.quiz.service.impl;

import com.quizApp.quiz.domain.Question;
import com.quizApp.quiz.repository.QuestionRepository;
import com.quizApp.quiz.requestWrapper.QuestionRequestWrapper;
import com.quizApp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    @Override
    public void createQuestion(QuestionRequestWrapper requestWrapper){
        Question question = new Question();
        question.setDescription(requestWrapper.getDescription());
        questionRepository.save(question);
    }
}
