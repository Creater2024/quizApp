package com.quizApp.quiz.domain;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name ="subject_name")
    private String name;

    @OneToMany(mappedBy = "subject")
    private List<Question> questionList;

    @OneToMany(mappedBy ="subject",cascade = CascadeType.ALL)
    private  List<Topic> topicList;
}
