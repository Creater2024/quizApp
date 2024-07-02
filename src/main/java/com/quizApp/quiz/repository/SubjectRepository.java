package com.quizApp.quiz.repository;

import com.quizApp.quiz.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
