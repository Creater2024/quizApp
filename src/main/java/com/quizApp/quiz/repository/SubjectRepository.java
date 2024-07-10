package com.quizApp.quiz.repository;

import com.quizApp.quiz.domain.Question;
import com.quizApp.quiz.domain.Subject;
import com.quizApp.quiz.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

    @Query("SELECT q FROM Question q WHERE q.subject.id = :subjectId")
    List<Question> findAllBySubjectId(@Param("subjectId") Long subjectId);

    @Query("SELECT t FROM Topic t WHERE t.subjectId = :subjectId")
    List<Topic> findAllTopicBySubjectId(@Param("subjectId") Long subjectId);
}
