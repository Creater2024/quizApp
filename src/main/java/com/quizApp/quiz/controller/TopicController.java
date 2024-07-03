package com.quizApp.quiz.controller;

import com.quizApp.quiz.requestWrapper.TopicRequestWrapper;
import com.quizApp.quiz.response.JSONObject;
import com.quizApp.quiz.service.TopicService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;
    @RequestMapping(value = "/addTopic",method = RequestMethod.POST)
    public ResponseEntity<JSONObject> addTopic(@RequestBody TopicRequestWrapper requestWrapper){
        try {
            topicService.createTopic(requestWrapper);
            return new ResponseEntity<>(new JSONObject("Success", 200, "Question added successfully"), HttpStatus.OK);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return new ResponseEntity<>(new JSONObject("Error", 400, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new JSONObject("Error", 500, "Internal server error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
