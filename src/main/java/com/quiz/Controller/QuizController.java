package com.quiz.Controller;

import com.quiz.Entity.Quiz;
import com.quiz.ServiceImpl.QuizServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizServiceImpl quizService;

    public QuizController(QuizServiceImpl quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    List<Quiz> getAllQuiz(){
        return quizService.getAllQuiz();
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
