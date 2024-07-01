package com.quizApp.quiz.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_topic")
public class SubTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id ;
    @Column(name = "sub_topic_name")
    private String name;
    @Column(name ="topic")
    private Long topic;
}
