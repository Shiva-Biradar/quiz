package com.test.quiz.Service;

import com.test.quiz.Dao.Questiondao;
import com.test.quiz.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    Questiondao questiondao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<List<Question>>  getAllQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questiondao.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
             questiondao.save(question);
            return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }


    }
}
