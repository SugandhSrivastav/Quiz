package com.quiz.Service;

import com.quiz.Entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {

    List<Quiz> getAllQuiz();
    Quiz getQuizById(Integer quizId);
    Quiz addQuiz(Quiz quiz);
}
