package com.quizApp.quiz.service;

import com.quizApp.quiz.domain.Question;
import com.quizApp.quiz.requestWrapper.QuestionRequestWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    void createQuestion(QuestionRequestWrapper requestWrapper);

    List<Question> getAllQuestion(Long subjectId,Long topicId,Long subTopicId);
}
