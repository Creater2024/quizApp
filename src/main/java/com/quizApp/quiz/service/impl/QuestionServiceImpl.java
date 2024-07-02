package com.quizApp.quiz.service.impl;

import com.quizApp.quiz.domain.Question;
import com.quizApp.quiz.domain.SubTopic;
import com.quizApp.quiz.domain.Subject;
import com.quizApp.quiz.domain.Topic;
import com.quizApp.quiz.repository.QuestionRepository;
import com.quizApp.quiz.repository.SubTopicRepository;
import com.quizApp.quiz.repository.SubjectRepository;
import com.quizApp.quiz.repository.TopicRepository;
import com.quizApp.quiz.requestWrapper.QuestionRequestWrapper;
import com.quizApp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final SubjectRepository subjectRepository;
    private final TopicRepository topicRepository;
    private final SubTopicRepository subTopicRepository;
    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository,
                               SubjectRepository subjectRepository,
                               TopicRepository topicRepository,
                               SubTopicRepository subTopicRepository){
        this.questionRepository = questionRepository;
        this.subjectRepository = subjectRepository;
        this.topicRepository = topicRepository;
        this.subTopicRepository = subTopicRepository;
    }

    @Override
    public void createQuestion(QuestionRequestWrapper requestWrapper){
        Subject subject = new Subject();
        Topic topic = new Topic();
        SubTopic subTopic = new SubTopic();
        Question question = new Question();
        if(requestWrapper.getSubTopicId() != null){
            subTopic = subTopicRepository.getById(requestWrapper.getSubTopicId());
            topic = subTopic.getTopic();
            subject = topic.getSubject();
            question.setSubTopic(subTopic);
            question.setTopic(topic);
            question.setSubject(subject);
        }
        else if(requestWrapper.getTopicId() != null){
            topic = subTopic.getTopic();
            subject = topic.getSubject();
            question.setTopic(topic);
            question.setSubject(subject);
        }

        question.setDescription(requestWrapper.getDescription());

        questionRepository.save(question);
    }
}
