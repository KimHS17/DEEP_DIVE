package com.example.mvcproject.quiz.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class QuizSession {
    private int quizId = 1;
    private int score = 0;

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public void calScore() {
        this.score += 10;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQuizId() {
        return quizId;
    }

    public int getScore() {
        return score;
    }
}
