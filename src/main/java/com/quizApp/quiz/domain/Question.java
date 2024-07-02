package com.quizApp.quiz.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_topic_id")
    private SubTopic subTopic;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Options> optionsList;

    @Column(name="correct_option")
    private Long correctOption;
    @Column(name ="solution")
    private Long solution;

}
