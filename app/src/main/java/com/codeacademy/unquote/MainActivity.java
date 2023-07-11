package com.codeacademy.unquote;

import java.util.ArrayList;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int currentQuestionIndex;
    int totalCorrect;
    int totalQuestions;
    ArrayList<Question> questions;
    ImageView questionImageView;
    TextView questionTextView;
    TextView questionsRemainingTextView;
    Button answer0Button;
    Button answer1Button;
    Button answer2Button;
    Button answer3Button;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_unquote_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setElevation(0);

        setContentView(R.layout.activity_main);

        questionImageView = findViewById(R.id.iv_main_question_image);
        questionTextView = findViewById(R.id.tv_main_question_title);
        questionsRemainingTextView = findViewById(R.id.tv_main_questions_remaining_count);
        answer0Button = findViewById(R.id.btn_main_answer_0);
        answer1Button = findViewById(R.id.btn_main_answer_1);
        answer2Button = findViewById(R.id.btn_main_answer_2);
        answer3Button = findViewById(R.id.btn_main_answer_3);
        submitButton = findViewById(R.id.btn_main_submit_answer);

        // TODO 4-E: set onClickListener for each answer Button

        // TODO 5-A: set onClickListener for the submit answer Button

        startNewGame();
    }


    void displayQuestion(Question question) {
        questionImageView.setImageResource(question.imageId);
        questionTextView.setText(question.questionText);
        answer0Button.setText(question.answer0);
        answer1Button.setText(question.answer1);
        answer2Button.setText(question.answer2);
        answer3Button.setText(question.answer3);
    }

    void displayQuestionsRemaining(int questionRemaining) {
        questionsRemainingTextView.setText(String.valueOf(questionRemaining));
    }


    // TODO 4-A: onAnswerSelected(int answerSelected) {...}


    // TODO #6 add onAnswerSubmission() here


    void onAnswerSubmission() {
        Question current = getCurrentQuestion();

        if (current.isCorrect()) {
            totalCorrect++;
        }
        questions.remove(current);

        // TODO 3-D.i: Uncomment the line below after implementing displayQuestionsRemaining(int)
        displayQuestionsRemaining(questions.size());

        if (questions.size() == 0) {
            String gameOverMessage = getGameOverMessage(totalCorrect, totalQuestions);

            // TODO 5-D: Show a popup instead
            System.out.println(gameOverMessage);
        } else {
            chooseNewQuestion();

            displayQuestion(getCurrentQuestion());
        }

    }


    void startNewGame() {
        questions = new ArrayList<>();

        Question question0 = new Question(R.drawable.img_quote_0,
                "Pretty good advice, and perhaps a scientist did say it…\n" +
                        "Who actually did?",
                "Albert Einstein",
                "Isaac Newton",
                "Rita Mae Brown",
                "Rosalind Franklin",
                2);

        Question question1 = new Question(R.drawable.img_quote_1,
                "Was honest Abe honestly quoted?\n" +
                        "Who authored this pithy bit of wisdom?",
                "Edward Stieglitz",
                "Maya Angelou",
                "Abraham Lincoln",
                "Ralph Waldo Emerson",
                0);

        Question question2 = new Question(R.drawable.img_quote_2,
                "Easy advice to read, difficult advice to follow — " +
                        "who actually said it?",
                "Martin Luther King Jr.",
                "Mother Teresa",
                "Fred Rogers",
                "Oprah Winfrey",
                1);

        Question question3 = new Question(R.drawable.img_quote_3,
                "Insanely inspiring, insanely incorrect (maybe).\n" +
                        "Who is the true source of this inspiration?",
                "Nelson Mandela",
                "Harriet Tubman",
                "Mahatma Gandhi",
                "Nicholas Klein",
                3);

        Question question4 = new Question(R.drawable.img_quote_4,
                "A peace worth striving for — who actually reminded us of this?",
                "Malala Yousafzai",
                "Martin Luther King Jr.",
                "Liu Xiaobo",
                "Dalai Lama",
                1);

        Question question5 = new Question(R.drawable.img_quote_5,
                "Unfortunately, true —\n" +
                        "but did Marilyn Monroe convey it or did someone else?",
                "Laurel Thatcher Ulrich",
                "Eleanor Roosevelt",
                "Marilyn Monroe",
                "Queen Victoria",
                0);

        questions.add(question0);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);

        totalCorrect = 0;
        totalQuestions = questions.size();

        Question firstQuestion = chooseNewQuestion();

        // TODO 3-D.ii: Uncomment the line below after implementing displayQuestionsRemaining(int)
        displayQuestionsRemaining(questions.size());

        displayQuestion(firstQuestion);
    }


    Question chooseNewQuestion() {
        int newQuestionIndex = generateRandomNumber(questions.size() - 1);
        currentQuestionIndex = newQuestionIndex;
        return questions.get(currentQuestionIndex);
    }


    Question getCurrentQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        return currentQuestion;
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
            return "You got " + totalCorrect + " right out of " + totalQuestions +
                    ". Better luck next time!";
        }
    }


}