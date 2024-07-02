package com.quizApp.quiz.requestWrapper;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class QuestionRequestWrapper {
    private String description;
    private Long subjectId;
    private Long topicId;
    private Long subTopicId;
}
