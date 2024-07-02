package com.quizApp.quiz.repository;

import com.quizApp.quiz.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {

}
