package com.quizApp.quiz.domain;

import jakarta.persistence.*;
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
    @Column(name = "sub_topic_name")
    private String name;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Topic topic;

    @ManyToOne
    private Subject subject;

    @OneToMany(mappedBy = "subTopic")
    private List<Question> questionList;
}
