package com.test.quiz.Model;

public class QuizWrapper {

    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuizWrapper(Integer id, String option1, String questionTitle, String option2, String option3, String option4) {
        this.id = id;
        this.option1 = option1;
        this.questionTitle = questionTitle;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
