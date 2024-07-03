package com.quizApp.quiz.service.impl;

import com.quizApp.quiz.domain.*;
import com.quizApp.quiz.repository.QuestionRepository;
import com.quizApp.quiz.repository.SubTopicRepository;
import com.quizApp.quiz.repository.SubjectRepository;
import com.quizApp.quiz.repository.TopicRepository;
import com.quizApp.quiz.requestWrapper.QuestionRequestWrapper;
import com.quizApp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private final QuestionRepository questionRepository;
    @Autowired
    private final SubjectRepository subjectRepository;
    @Autowired
    private final TopicRepository topicRepository;
    @Autowired
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
        if(requestWrapper == null || requestWrapper.getDescription() == null || requestWrapper.getDescription().trim().isBlank()){
            throw new IllegalArgumentException("Desciption is not found");
        }
        Subject subject = new Subject();
        Topic topic = new Topic();
        SubTopic subTopic = new SubTopic();
        Question question = new Question();
        if(requestWrapper.getSubTopicId() != null){
            subTopic = subTopicRepository.findById(requestWrapper.getSubTopicId())
                    .orElseThrow(() -> new IllegalArgumentException("SubTopic not found with id: " + requestWrapper.getSubTopicId()));
            topic = topicRepository.findById(requestWrapper.getTopicId())
                    .orElseThrow(() -> new IllegalArgumentException("Topic not found with id: " + requestWrapper.getTopicId()));
            subject = subjectRepository.findById(requestWrapper.getSubjectId())
                    .orElseThrow(() -> new IllegalArgumentException("SubTopic not found with id: " + requestWrapper.getSubjectId()));
            question.setSubTopic(subTopic);
            question.setTopic(topic);
            question.setSubject(subject);
        }
        else if(requestWrapper.getTopicId() != null){
            topic = topicRepository.findById(requestWrapper.getTopicId())
                    .orElseThrow(() -> new IllegalArgumentException("Topic not found with id: " + requestWrapper.getTopicId()));
            subject = subjectRepository.findById(requestWrapper.getSubjectId())
                    .orElseThrow(() -> new IllegalArgumentException("SubTopic not found with id: " + requestWrapper.getSubjectId()));
            question.setTopic(topic);
            question.setSubject(subject);
        }
        requestWrapper.getOptionsList().forEach(option -> {
            if(option == null || option.getValue() == null || option.getValue().trim().isBlank()){
                throw new IllegalArgumentException("option value is not found");
            }
            Options options = new Options();
            options.setValue(option.getValue());
            options.setQuestion(question);
            options.setOptionCorrect(option.isOptionCorrect());
            System.out.println("isOptionCorrect :" + option.isOptionCorrect());
            question.addOption(options);
        });
        question.setDescription(requestWrapper.getDescription());
        questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestion(Long subjectId,Long topicId,Long subTopicId){
        List<Question> questionList = new ArrayList<>();
        if(subTopicId != null){
            SubTopic subTopic = new SubTopic();
            subTopic = subTopicRepository.findById(subTopicId)
                    .orElseThrow(() -> new IllegalArgumentException("SubTopic not found with id: " + subTopicId));
            questionList = subTopicRepository.findAllQuestionsBySubTopicIdAndTopicIdAndSubjectId(subTopicId,topicId,subjectId);
        }
        else if(topicId != null){
            Topic topic = new Topic();
            topic = topicRepository.findById(topicId)
                    .orElseThrow(() -> new IllegalArgumentException("Topic not found with id: " + topicId));
            questionList = topicRepository.findAllQuestionsByTopicIdAndSubjectId(topicId,subjectId);
        }
        else if (subjectId != null) {
            Subject subject = new Subject();
            subject = subjectRepository.findById(subjectId)
                    .orElseThrow(()-> new IllegalArgumentException("Subject not found with id: " + subjectId));
            questionList = subjectRepository.findAllBySubjectId(subjectId);
        }
        else{
            questionList = questionRepository.findAll();
        }
        return questionList;
    }
}
