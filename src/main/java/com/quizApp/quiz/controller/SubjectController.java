package com.quizApp.quiz.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.quizApp.quiz.requestWrapper.SubjectRequestWrapper;
import com.quizApp.quiz.response.JSONObject;
import com.quizApp.quiz.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value="/addSubject",method = RequestMethod.POST)
    public ResponseEntity<JSONObject> addSubject(@RequestBody SubjectRequestWrapper requestWrapper){
        subjectService.createSubject(requestWrapper);
        JSONObject Data = new JSONObject("Success",200,"Success");
        return new ResponseEntity<>(Data, HttpStatus.OK);
    }
}
