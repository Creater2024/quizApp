package com.quizApp.quiz.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name ="topic_name")
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Subject subject;

    @OneToMany(mappedBy = "topic")
    private List<Question> questionList;

    @OneToMany(mappedBy = "topic",cascade = CascadeType.ALL)
    private List<SubTopic> subTopicList;
}
