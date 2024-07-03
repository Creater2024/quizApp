package com.quizApp.quiz.repository;

import com.quizApp.quiz.domain.Question;
import com.quizApp.quiz.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    @Query("SELECT q FROM Question q WHERE q.topic.id = :topicId AND q.subject.id = :subjectId")
    List<Question> findAllQuestionsByTopicIdAndSubjectId(@Param("topicId") Long topicId, @Param("subjectId") Long subjectId);
}
