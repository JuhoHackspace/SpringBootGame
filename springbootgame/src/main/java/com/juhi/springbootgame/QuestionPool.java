package com.juhi.springbootgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class QuestionPool {
    private List<Question> questions;
    private List<Integer> shownQuestions;
    Random random;
    public QuestionPool() {
        questions = new ArrayList<>();
        shownQuestions = new ArrayList<>();
        random = new Random();

        questions.add(new Question("What country is the city Hongkong in", new ArrayList<>(Arrays.asList("A. China","B. Taiwan","C. Korea","D. Japan")),'A'));
        questions.add(new Question("Which planet is known as the Red Planet?", new ArrayList<>(Arrays.asList("A. Mars","B. Jupiter","C. Venus","D. Saturn")), 'A'));
        questions.add(new Question("Who wrote 'Romeo and Juliet'?", new ArrayList<>(Arrays.asList("A. Charles Dickens","B. William Shakespeare","C. Jane Austen","D. Mark Twain")), 'B'));
        questions.add(new Question("What is the largest ocean on Earth?", new ArrayList<>(Arrays.asList("A. Atlantic ocean","B. Indian ocean","C. Southern ocean","D. Pacific ocean")), 'D'));
        questions.add(new Question("Which programming language is known for its versatility and use in web development?", new ArrayList<>(Arrays.asList("A. Java","B. Python","C. C++","D. Ruby")), 'A'));
        questions.add(new Question("In which year did the alleged first manned moon landing occur?", new ArrayList<>(Arrays.asList("A. 1969","B. 1975","C. 1982","D. 1990")), 'A'));
        questions.add(new Question("What is the powerhouse of the cell?", new ArrayList<>(Arrays.asList("A. Nucleus","B. Mitochondria","C. Endoplasmic reticulum","D. Golgi apparatus")), 'B'));
        questions.add(new Question("Which country is known as the Land of the Rising Sun?", new ArrayList<>(Arrays.asList("A. China","B. South Korea","C. Japan","D. Vietnam")), 'C'));
        questions.add(new Question("Who painted the Mona Lisa?", new ArrayList<>(Arrays.asList("A. Vincent Van Gogh","B. Leondardo da Vinci","C. Pablo Picasso","D. Michelangelo")), 'B'));
        questions.add(new Question("What is the currency of Japan?", new ArrayList<>(Arrays.asList("A. Won","B. Yen","C. Euro","D. Peso")), 'B'));
        questions.add(new Question("Which gas do plants absorb during photosynthesis?", new ArrayList<>(Arrays.asList("A. Oxygen","B. Nitrogen","C. Carbon dioxide","D. Hydrogen")), 'C'));
        questions.add(new Question("In which year did the Titanic sink?", new ArrayList<>(Arrays.asList("A. 1905","B. 1931","C. 1920","D. 1912")), 'D'));
        questions.add(new Question("Who wrote 'To Kill a Mockingbird'?", new ArrayList<>(Arrays.asList("A. George Orwell","B. Harper Lee","C. J.K Rowling","D. Ernest Hemingway")), 'B'));
        questions.add(new Question("What is the largest mammal on Earth?", new ArrayList<>(Arrays.asList("A. Elephant","B. Giraffe","C. Blue whale","D. Rhinoceros")), 'C'));
        questions.add(new Question("Which famous scientist developed the theory of general relativity?", new ArrayList<>(Arrays.asList("A. Isaac Newton","B. Albert Einstein","C. Galileo Galilei","D. Nikola Tesla")), 'B'));
        questions.add(new Question("What is the capital of Australia?", new ArrayList<>(Arrays.asList("A. Sydney","B. Canberra","C. Melbourne","D. Brisbane")), 'A'));
        questions.add(new Question("Which element has the chemical symbol 'H'?", new ArrayList<>(Arrays.asList("A. Helium","B. Hydrogen","C. Hafnium","D. Holmium")), 'B'));
        questions.add(new Question("Who is known as the Father of Computer Science?", new ArrayList<>(Arrays.asList("A. Bill Gates","B. Alan Turing","C. Steve Jobs","D. Tim Berners-Lee")), 'B'));
        questions.add(new Question("What is the main ingredient in guacamole?", new ArrayList<>(Arrays.asList("A. Tomatoes","B. Onions","C. Avocado","D. Cilantro")), 'C'));
        questions.add(new Question("Which mountain is the highest in the world?", new ArrayList<>(Arrays.asList("A. Mount Kilimanjaro","B. Mount Everest","C. Mount McKinley","D. Mount Fuji")), 'B'));
    }

    public Question randomQuestion() {
        while(true) {
            int index = random.nextInt(20);
            if(shownQuestions.size() == 20) {
                shownQuestions.clear();
            }
            if(!shownQuestions.contains(index)) {
                shownQuestions.add(index);
                return questions.get(index);
            }
        }
    }

    public void resetShownQuestions() {
        shownQuestions.clear();
    }
}
