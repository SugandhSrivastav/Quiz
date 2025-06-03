package com.quiz.Controller;

import com.quiz.Entity.Quiz;
import com.quiz.Service.QuestionClient;
import com.quiz.ServiceImpl.QuizServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizServiceImpl quizService;
    private final QuestionClient questionClient;

    public QuizController(QuizServiceImpl quizService,QuestionClient questionClient) {
        this.quizService = quizService;
        this.questionClient = questionClient;
    }

    @GetMapping
    List<Quiz> getAllQuiz(){
        List<Quiz> quizes = quizService.getAllQuiz();
        return quizes.stream().map(quiz ->{
            quiz.setQuestion(questionClient.getQuestionByQuizId(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{qId}")
    Quiz getQuizById(@PathVariable Integer qId){
        return quizService.getQuizById(qId);
    }

    @PostMapping
    Quiz addQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

}
