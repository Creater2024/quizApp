package com.quizApp.quiz.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.quizApp.quiz.domain.Question;
import com.quizApp.quiz.domain.Subject;
import com.quizApp.quiz.domain.Topic;
import com.quizApp.quiz.requestWrapper.SubjectRequestWrapper;
import com.quizApp.quiz.response.JSONObject;
import com.quizApp.quiz.service.SubjectService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value="/addSubject",method = RequestMethod.POST)
    public ResponseEntity<JSONObject> addSubject(@RequestBody SubjectRequestWrapper requestWrapper){
        try {
            subjectService.createSubject(requestWrapper);
            return new ResponseEntity<>(new JSONObject("Success", 200, "Question added successfully"), HttpStatus.OK);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return new ResponseEntity<>(new JSONObject("Error", 400, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new JSONObject("Error", 500, "Internal server error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/getAllTopics",method = RequestMethod.GET)
    public ResponseEntity<JSONObject> getAllTopics(@RequestParam(name = "subject_id",required = true) Long subjectId){
        try {
            List<Topic> topicList = subjectService.getAllTopics(subjectId);
            return new ResponseEntity<>(new JSONObject("Success", 200, "List of Topics",topicList), HttpStatus.OK);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return new ResponseEntity<>(new JSONObject("Error", 400, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new JSONObject("Error", 500, "Internal server error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/getAllSubjects",method = RequestMethod.GET)
    public ResponseEntity<JSONObject> getAllSubjects(){
        try {
            List<Subject> subjectList = subjectService.getAllSubject();
            return new ResponseEntity<>(new JSONObject("Success", 200, "List of Subject",subjectList), HttpStatus.OK);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return new ResponseEntity<>(new JSONObject("Error", 400, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new JSONObject("Error", 500, "Internal server error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
