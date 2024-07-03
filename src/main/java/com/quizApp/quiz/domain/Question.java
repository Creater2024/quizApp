package com.quizApp.quiz.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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
    @Column(name ="description",nullable = false)
    private String description;
    @Column(name ="image")
    private Long image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id",nullable = false)
    private Subject subject;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id",nullable = false)
    private Topic topic;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_topic_id")
    private SubTopic subTopic;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Options> optionsList =  new ArrayList<>();

//    @Column(name="correct_option")
//    private List<Options> correctOptionList = new ArrayList<>();
    @Column(name ="solution")
    private Long solution;

    public void addOption(Options option) {
        optionsList.add(option);
        option.setQuestion(this);
    }

    public void removeOption(Options option) {
        optionsList.remove(option);
    }


}
