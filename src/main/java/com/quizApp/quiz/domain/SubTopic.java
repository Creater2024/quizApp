package com.quizApp.quiz.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sub_topic")
public class SubTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id ;
    @Column(name = "sub_topic_name",nullable = false)
    private String name;

    @Column(name = "topic_id",nullable = false)
    private Long topicId;

    @Column(name = "subject_id",nullable = false)
    private Long subjectId;

}
