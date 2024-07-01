package com.quizApp.quiz.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id ;

    @Column(name ="description")
    private String description;
    @Column(name ="image")
    private Long image;
    @Column(name="subject")
    private Long subject;
    @Column(name="topic")
    private Long topic;
    @Column(name ="sub_topic")
    private Long subTopic;
    @Column(name ="options")
    private Long[] options;
    @Column(name="correct_option")
    private Long correctOption;
    @Column(name ="solution")
    private Long solution;

}
