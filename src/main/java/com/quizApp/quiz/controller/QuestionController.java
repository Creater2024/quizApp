package com.quizApp.quiz.controller;


import com.quizApp.quiz.requestWrapper.QuestionRequestWrapper;
import com.quizApp.quiz.response.JSONObject;
import com.quizApp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @RequestMapping(value = "/addQuestion",method = RequestMethod.POST)
    public ResponseEntity<JSONObject> addQuestion(@RequestBody QuestionRequestWrapper questionRequestWrapper){
        System.out.println("---------------------------" + questionRequestWrapper.getDescription() +"----------------");
        questionService.createQuestion(questionRequestWrapper);
        JSONObject Data = new JSONObject("Success",200,"Success");
        return new ResponseEntity<>(Data, HttpStatus.OK);
    }
}
