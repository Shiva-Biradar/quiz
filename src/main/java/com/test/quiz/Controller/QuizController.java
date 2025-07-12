package com.test.quiz.Controller;

import com.test.quiz.Model.Quiz;
import com.test.quiz.Model.QuizWrapper;
import com.test.quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;
    @PostMapping("Create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return  quizService.CreateQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuizWrapper>> getQuiz(@PathVariable int id) {

        List<QuizWrapper> qw=quizService.getquiz(id);

        return new ResponseEntity<>(qw,HttpStatus.OK);

    }
}
