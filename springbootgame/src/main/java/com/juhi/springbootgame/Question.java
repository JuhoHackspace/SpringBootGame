package com.juhi.springbootgame;

import java.util.List;

public class Question {
    private String question;
    private List<String> options;
    private char answer;

    public Question(String question, List<String> options, char answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public char getCorrectAnswer() {
        return answer;
    }

    public String toString() {
        String output = "";
        output += question + System.lineSeparator();
        for(String option: options) {
            output += option + System.lineSeparator();
        }
        return output;
    }
}
