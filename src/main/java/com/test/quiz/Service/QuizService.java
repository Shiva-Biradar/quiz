package com.test.quiz.Service;

import com.test.quiz.Dao.Questiondao;
import com.test.quiz.Dao.QuizDao;
import com.test.quiz.Model.Question;
import com.test.quiz.Model.Quiz;
import com.test.quiz.Model.QuizWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    Questiondao questiondao;

    public ResponseEntity<String> CreateQuiz(String category, int numQ, String title) {

        List<Question> questions = questiondao.findRandomQuestionByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public List<QuizWrapper> getquiz(int id) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questionFromDB=quiz.get().getQuestions();
        List<QuizWrapper> quizWrapperList=new ArrayList<>();
        for(Question q:questionFromDB){
            QuizWrapper qw=new QuizWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            quizWrapperList.add(qw);
        }

        return quizWrapperList;
    }
}
