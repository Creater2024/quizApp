package com.quizApp.quiz.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class options {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name ="value")
    private String value;
    @Column(name = "question")
    private Long question;
}
