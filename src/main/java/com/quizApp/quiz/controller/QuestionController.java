package com.quizApp.quiz.controller;


import com.quizApp.quiz.domain.Question;
import com.quizApp.quiz.requestWrapper.QuestionRequestWrapper;
import com.quizApp.quiz.response.JSONObject;
import com.quizApp.quiz.service.QuestionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @RequestMapping(value = "/addQuestion",method = RequestMethod.POST)
    public ResponseEntity<JSONObject> addQuestion(@RequestBody QuestionRequestWrapper questionRequestWrapper){
        try {
            questionService.createQuestion(questionRequestWrapper);
            return new ResponseEntity<>(new JSONObject("Success", 200, "Question added successfully"), HttpStatus.OK);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return new ResponseEntity<>(new JSONObject("Error", 400, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new JSONObject("Error", 500, "Internal server error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/getAllQuestion",method = RequestMethod.GET)
    public ResponseEntity<JSONObject> getAllQuestions(@RequestParam(name = "subject_id",required = false) Long subjectId,
                                                      @RequestParam(name = "topic_id",required = false)Long topicId,
                                                      @RequestParam(name = "sub_topic_id",required = false)Long subTopicId){
        try {
            List<Question> questionList = questionService.getAllQuestion(subjectId,topicId,subTopicId);
            return new ResponseEntity<>(new JSONObject("Success", 200, "List of Questions",questionList), HttpStatus.OK);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return new ResponseEntity<>(new JSONObject("Error", 400, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new JSONObject("Error", 500, "Internal server error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
