package com.quizApp.quiz.controller;


import com.quizApp.quiz.domain.SubTopic;
import com.quizApp.quiz.requestWrapper.SubTopicRequestWrapper;
import com.quizApp.quiz.response.JSONObject;
import com.quizApp.quiz.service.SubTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/subTopic")
public class SubTopicController {
    @Autowired
    private SubTopicService subTopicService;
    @RequestMapping(value = "/addSubTopic",method = RequestMethod.POST)
    public ResponseEntity<JSONObject> addSubTopic(@RequestBody SubTopicRequestWrapper requestWrapper){
        subTopicService.createSubTopic(requestWrapper);
        JSONObject Data = new JSONObject("Success",200,"Success");
        return new ResponseEntity<>(Data, HttpStatus.OK);
    }
}
