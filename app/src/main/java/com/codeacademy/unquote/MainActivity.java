package com.codeacademy.unquote;

import java.util.ArrayList;







//My code from Codecademy:
public class MainActivity {

    // TODO #1: add integer member variables here
    int currentQuestionIndex;
    int totalCorrect;
    int totalQuestions;

    // TODO #2: add ArrayList member variable here
    ArrayList<Question> questions = new ArrayList<Question>();

    // TODO #3 add startNewGame() here
    void startNewGame() {
        totalCorrect = 0;
        totalQuestions = 0;

        Question oFirstQuestion = new Question(921238, "How tall is the Eiffel tower?", "1024 ft", "1063 ft", "1124 ft", "1163 ft", 1);
        Question oSecondQuestion = new Question(107343, "Who invented the computer algorithm?", "Charles Babbage", "John Carmack", "Alan Turing", "Ada Lovelace", 3);
        Question oThirdQuestion = new Question(748294, "What is the name for the patch of skin found on your elbow?", "Elbow Skin", "Fascia Elbora", "Wenis", "Todd", 2);

        ArrayList<Question> questions = new ArrayList<>();
        questions.add(oFirstQuestion);
        questions.add(oSecondQuestion);
        questions.add(oThirdQuestion);

        Question firstQuestion = chooseNewQuestion();
        // displayQuestion(firstQuewstion);
        // displayQuestionsRemaining(questions.size());
        // TODO: uncomment after implementing
        // displayquestion();
        // displayQuestion(getCurrentQuestion);
    }

    // TODO #4 add chooseNewQuestion() here
    Question chooseNewQuestion() {
        int randomQuestion = generateRandomNumber(questions.size() - 1);
        currentQuestionIndex = questions.indexOf(randomQuestion);
        return questions.get(currentQuestionIndex);
    }

    // TODO #5 add getCurrentQuestion() here
    Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    // TODO #6 add onAnswerSubmission() here
    void onAnswerSubmission() {
        Question current = getCurrentQuestion();

        if (current.isCorrect()) {
            totalCorrect++;
        }
        questions.remove(current);
        // displayQuestionsRemaining(questions.size);
        if (questions.size() == 0) {
            System.out.println("game over");
            startNewGame();
        } else {
            chooseNewQuestion();
        }

    }

    int generateRandomNumber(int max) {
        double randomNumber = Math.random();
        double result = max * randomNumber;
        return (int) result;
    }

    String getGameOverMessage(int totalCorrect, int totalQuestions) {
        if (totalCorrect == totalQuestions) {
            return "You got all " + totalQuestions + " right! You won!";
        } else {
            return "You got " + totalCorrect + " right out of " + totalQuestions + ". Better luck next time!";
        }
    }
}