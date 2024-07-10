package com.quizApp.quiz.repository;

import com.quizApp.quiz.domain.Question;
import com.quizApp.quiz.domain.SubTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubTopicRepository extends JpaRepository<SubTopic,Long> {

    @Query("SELECT q FROM Question q WHERE q.subTopic.id = :subTopicId AND q.topic.id = :topicId AND q.subject.id = :subjectId")
    List<Question> findAllQuestionsBySubTopicIdAndTopicIdAndSubjectId(@Param("subTopicId") Long subTopicId,
                                                                      @Param("topicId") Long topicId,
                                                                      @Param("subjectId") Long subjectId);




}
