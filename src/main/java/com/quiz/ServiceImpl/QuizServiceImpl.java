package com.quiz.ServiceImpl;

import com.quiz.Entity.Quiz;
import com.quiz.Repository.QuizRepository;
import com.quiz.Service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository){
        this.quizRepository = quizRepository;
    }
    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuizById(Integer quizId) {
        return quizRepository.findById(quizId).orElseThrow(()-> new RuntimeException("Quiz not Found!!"));
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }
}
