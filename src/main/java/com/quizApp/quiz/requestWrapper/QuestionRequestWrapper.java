package com.quizApp.quiz.requestWrapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class QuestionRequestWrapper {
    private String description;
    private Long subjectId;
    private Long topicId;
    private Long subTopicId;
    private List<OptionRequestWrapper> optionsList;
}
