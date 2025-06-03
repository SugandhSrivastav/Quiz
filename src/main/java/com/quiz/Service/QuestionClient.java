package com.quiz.Service;

import com.quiz.Entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8081",value = "Question-Client")
public interface QuestionClient {

    @GetMapping("/question")
    public List<Question> getAllQuestion();

    @GetMapping("/question/quiz/{quizId}")
    public List<Question> getQuestionByQuizId(@PathVariable Integer quizId);

}
