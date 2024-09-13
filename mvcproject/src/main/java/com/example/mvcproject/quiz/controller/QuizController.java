package com.example.mvcproject.quiz.controller;

import com.example.mvcproject.quiz.domain.QuizQuestion;
import com.example.mvcproject.quiz.service.QuizSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {
    @Autowired
    private QuizSession quizSession;
    private QuizQuestion[] quizQuestions;

    public QuizController() {
        quizQuestions = new QuizQuestion[3];
        quizQuestions[0] = new QuizQuestion(1, "한국의 수도는?", "서울");
        quizQuestions[1] = new QuizQuestion(2, "영국의 수도는?", "런던");
        quizQuestions[2] = new QuizQuestion(3, "프랑스의 수도는?", "파리");
    }

    // http://localhost:8080/quiz
    @GetMapping("/quiz")
    public String quiz(Model model) {
        model.addAttribute("id", quizSession.getQuizId());
        model.addAttribute("score", quizSession.getScore());
        model.addAttribute("quiz", quizQuestions[quizSession.getQuizId() - 1].getQuestion());

        return "quiz";
    }

    @PostMapping("/quiz")
    public String quiz(@RequestParam String answer) {
        if(answer.equals(quizQuestions[quizSession.getQuizId() - 1].getAnswer())) {
            quizSession.calScore();
        }
        quizSession.setQuizId(quizSession.getQuizId() + 1);
        if(quizSession.getQuizId() > 3) {
            return "redirect:/quiz-result";
        }
        return "redirect:/quiz";
    }

    @GetMapping("/quiz-result")
    public String quizResult(Model model) {
        model.addAttribute("score", quizSession.getScore());
        return "quizResult";
    }

    @PostMapping("/restart")
    public String restart() {
        quizSession.setQuizId(1);
        quizSession.setScore(0);
        return "redirect:/quiz";
    }
}
