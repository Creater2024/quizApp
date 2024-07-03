package com.quizApp.quiz.requestWrapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptionRequestWrapper {
    private String value;
    private boolean isOptionCorrect;
}
