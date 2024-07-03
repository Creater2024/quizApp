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
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/api/v1/subTopic")
public class SubTopicController {
    @Autowired
    private SubTopicService subTopicService;
    @RequestMapping(value = "/addSubTopic",method = RequestMethod.POST)
    public ResponseEntity<JSONObject> addSubTopic(@RequestBody SubTopicRequestWrapper requestWrapper){
        try {
            subTopicService.createSubTopic(requestWrapper);
            return new ResponseEntity<>(new JSONObject("Success", 200, "Question added successfully"), HttpStatus.OK);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return new ResponseEntity<>(new JSONObject("Error", 400, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new JSONObject("Error", 500, "Internal server error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
