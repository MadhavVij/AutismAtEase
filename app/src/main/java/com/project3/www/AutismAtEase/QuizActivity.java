package com.project3.www.AutismAtEase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private String output;
    private TextView result;


    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;


    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question);
        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);


        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here
                Log.d(AppSettings.tagAS, "onClick: b1,b2,ans" + mButtonChoice1.getText() + mButtonChoice2.getText() + mAnswer);
                if (mButtonChoice1.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                   /* //This line of code is optiona
                    Toast.makeText(QuizActivity.this, "next question", Toast.LENGTH_SHORT).show();
*/
                } else {
                    mScore = mScore - 1;
                    updateScore(mScore);

                    /*Toast.makeText(QuizActivity.this, "next question", Toast.LENGTH_SHORT).show();*/
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here
                Log.d(AppSettings.tagAS, "onClick: b1,b2,ans" + mButtonChoice1.getText() + mButtonChoice2.getText() + mAnswer);
                if (mButtonChoice2.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    /* Toast.makeText(QuizActivity.this, "next question", Toast.LENGTH_SHORT).show();*/

                } else {
                    mScore = mScore - 1;
                    updateScore(mScore);
                    /*     Toast.makeText(QuizActivity.this, "next question", Toast.LENGTH_SHORT).show();*/
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


    }

    //End of Button Listener for Button3


    private void updateQuestion() {
        if (mQuestionNumber < 14) {

            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;

        } else {
            Toast.makeText(QuizActivity.this, "Thankyou for your submission", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, Result.class);
            if (Integer.parseInt(mScoreView.getText().toString()) > 7) {


                output = "No Risk Detected";
                result = findViewById(R.id.final_result);

                i.putExtra("op", output);
                Log.d(AppSettings.tagAS, "updateQuestion: " + output);
                startActivity(i);


            } else {

                if (Integer.parseInt(mScoreView.getText().toString()) > 0 && Integer.parseInt(mScoreView.getText().toString()) < 7) {
                    output = "Low Risk Detected";
                    result = findViewById(R.id.final_result);

                    i.putExtra("op", output);
                    Log.d(AppSettings.tagAS, "updateQuestion: " + output);
                    startActivity(i);


                } else {

                    if (Integer.parseInt(mScoreView.getText().toString()) < 0) {
                        output = "High Risk Detected";
                        result = findViewById(R.id.final_result);

                        i.putExtra("op", output);
                        Log.d(AppSettings.tagAS, "updateQuestion: " + output);
                        startActivity(i);
                    }


                }


            }

        }
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}

