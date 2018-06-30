package com.example.android.worldcupquizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked for question 1
        switch (view.getId()) {
            case R.id.Q1a:
                if (checked)
                    //nothing
                    break;
            case R.id.Q1b:
                if (checked)
                    //nothing
                    break;
            case R.id.Q1c:
                if (checked)
                    score += 1;
                break;
        }
        // Check which radio button was clicked for question 2
        switch (view.getId()) {
            case R.id.Q2a:
                if (checked)
                    score += 1;
                break;
            case R.id.Q2b:
                if (checked)
                    //nothing
                    break;
            case R.id.Q2c:
                if (checked)
                    //nothing
                    break;
        }
// Check which radio button was clicked for question 3
        switch (view.getId()) {
            case R.id.Q3a:
                if (checked)
                    //nothing
                    break;
            case R.id.Q3b:
                if (checked)
                    //nothing
                    break;
            case R.id.Q3c:
                if (checked)
                    score += 1;
                break;
        }
        // Check which radio button was clicked for question 4
        switch (view.getId()) {
            case R.id.Q4a:
                if (checked)
                    score += 1;
                break;
            case R.id.Q4b:
                if (checked)
                    //nothing
                    break;
            case R.id.Q4c:
                if (checked)
                    //nothing
                    break;
        }
        // Check which radio button was clicked for question 5
        switch (view.getId()) {
            case R.id.Q5a:
                if (checked)
                    //nothing
                    break;
            case R.id.Q5b:
                if (checked)
                    score += 1;
                break;
            case R.id.Q5c:
                if (checked)
                    //nothing
                    break;
        }
// Check which radio button was clicked for question 6
        switch (view.getId()) {
            case R.id.Q6a:
                if (checked)
                    score += 1;
                break;
            case R.id.Q6b:
                if (checked)
                    //nothing
                    break;
            case R.id.Q6c:
                if (checked)
                    //nothing
                    break;
        }
        // Check which radio button was clicked for question 7
        switch (view.getId()) {
            case R.id.Q7a:
                if (checked)
                    //nothing
                    break;
            case R.id.Q7b:
                if (checked)
                    score += 1;
                break;
            case R.id.Q7c:
                if (checked)
                    //nothing
                    break;
        }
// Check which radio button was clicked for question 8
        switch (view.getId()) {
            case R.id.Q8a:
                if (checked)
                    score += 1;
                break;
            case R.id.Q8b:
                if (checked)
                    //nothing
                    break;
            case R.id.Q8c:
                if (checked)
                    //nothing
                    break;
        }
        // Check which radio button was clicked for question 9
        switch (view.getId()) {
            case R.id.Q9a:
                if (checked)
                    score += 1;
                break;
            case R.id.Q9b:
                if (checked)
                    //nothing
                    break;
            case R.id.Q9c:
                if (checked)
                    //nothing
                    break;
        }
    }

    // Check which radio button was clicked for question 11
    public void onCheckBoxClicked(View view) {
        // Is the button now checked?
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.argentina:
                if (checked)
                    score += 1;
                break;
            case R.id.france:
                if (checked)
                    score += 1;
                break;
            case R.id.brazil:
                if (checked)
                    score += 1;
                break;
            case R.id.peru:
                if (checked)
                    //nothing
                    break;
        }
        //Hide Submit button
        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setVisibility(View.VISIBLE);

    }

    //Submit Button to calculate scores
    public void submitAnswers(View view) {
        //get input from the name EditText field
        EditText text = (EditText) findViewById(R.id.name_view);
        String name = text.getText().toString();

        //get input from the support team EditText fiel
        EditText team = (EditText) findViewById(R.id.Team);
        String support = team.getText().toString();

        //generate the results message
        String results = "Hello " + name + ". Thank you for answering the world cup questions. Here are your results";
        results += "\nYou scored " + score + " out of 12";
        results += "\nYou are supporting " + support + ". If your team wins you get KSh 1000 from us.";

        //make the score text view visible
        TextView viewScore = (TextView) findViewById(R.id.score);
        viewScore.setVisibility(View.VISIBLE);
        //display results
        TextView resultTextView = (TextView) findViewById(R.id.score);
        resultTextView.setText(results);

        //display a toast message for results
        Toast.makeText(this, ("Your score is " + score), Toast.LENGTH_SHORT).show();
        //unhide the view answers button
        Button viewAnswers = (Button) findViewById(R.id.answers);
        viewAnswers.setVisibility(View.VISIBLE);

        //disable submit button to prevent resubmissions
        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setEnabled(false);
    }

    //Restart button to reset quiz
    public void Retry(View view) {
        //Reset Score
        score = 0;

        //Make answers and score invisible and make submit visible
        Button viewAnswers = (Button) findViewById(R.id.answers);
        viewAnswers.setVisibility(View.INVISIBLE);
        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setVisibility(View.VISIBLE);
        TextView score = (TextView) findViewById(R.id.score);
        score.setVisibility(View.INVISIBLE);


        //enable submit and answers button
        submitButton.setEnabled(true);
        viewAnswers.setEnabled(true);

        //Clear or hide answers
        clearRadioButtons();
        clearCheckedBoxes();
        hideAnswers();

        Toast.makeText(this, "Quiz Reset", Toast.LENGTH_SHORT).show();

    }

    //Clear RadioGroup Actions
    public void clearRadioButtons() {
        RadioGroup qOne = (RadioGroup) findViewById(R.id.group1);
        qOne.clearCheck();
        RadioGroup qTwo = (RadioGroup) findViewById(R.id.group2);
        qTwo.clearCheck();
        RadioGroup qThree = (RadioGroup) findViewById(R.id.group3);
        qThree.clearCheck();
        RadioGroup qFour = (RadioGroup) findViewById(R.id.group4);
        qFour.clearCheck();
        RadioGroup qFive = (RadioGroup) findViewById(R.id.group5);
        qFive.clearCheck();
        RadioGroup qSix = (RadioGroup) findViewById(R.id.group6);
        qSix.clearCheck();
        RadioGroup qSeven = (RadioGroup) findViewById(R.id.group7);
        qSeven.clearCheck();
        RadioGroup qEight = (RadioGroup) findViewById(R.id.group8);
        qEight.clearCheck();
        RadioGroup qNine = (RadioGroup) findViewById(R.id.group9);
        qNine.clearCheck();
    }

    //Clear Checked boxes
    public void clearCheckedBoxes() {
        CheckBox argentina = (CheckBox) findViewById(R.id.argentina);
        argentina.setChecked(false);
        CheckBox france = (CheckBox) findViewById(R.id.france);
        france.setChecked(false);
        CheckBox brazil = (CheckBox) findViewById(R.id.brazil);
        brazil.setChecked(false);
        CheckBox peru = (CheckBox) findViewById(R.id.peru);
        peru.setChecked(false);

    }

    //To show answers
    public void Answers(View view) {
        //Show answer text boxes
        TextView one = (TextView) findViewById(R.id.answer_one);
        one.setVisibility(View.VISIBLE);
        TextView two = (TextView) findViewById(R.id.answer_two);
        two.setVisibility(View.VISIBLE);
        TextView three = (TextView) findViewById(R.id.answer_three);
        three.setVisibility(View.VISIBLE);
        TextView four = (TextView) findViewById(R.id.answer_four);
        four.setVisibility(View.VISIBLE);
        TextView five = (TextView) findViewById(R.id.answer_five);
        five.setVisibility(View.VISIBLE);
        TextView six = (TextView) findViewById(R.id.answer_six);
        six.setVisibility(View.VISIBLE);
        TextView seven = (TextView) findViewById(R.id.answer_seven);
        seven.setVisibility(View.VISIBLE);
        TextView eight = (TextView) findViewById(R.id.answer_eight);
        eight.setVisibility(View.VISIBLE);
        TextView nine = (TextView) findViewById(R.id.answer_nine);
        nine.setVisibility(View.VISIBLE);
        TextView ten = (TextView) findViewById(R.id.answer_ten);
        ten.setVisibility(View.VISIBLE);


        //Hide Submit button
        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setEnabled(false);

        //Disable Answers button to prevent resubmissions
        Button answerButton = (Button) findViewById(R.id.answers);
        answerButton.setEnabled(false);
        //Make retry invisible
        Button retry = (Button) findViewById(R.id.retry);
        retry.setVisibility(View.VISIBLE);

        Toast.makeText(this, "Answers now shown\nRestart to continue", Toast.LENGTH_SHORT).show();

    }

    //Action to hide all the answers made visible
    public void hideAnswers() {

        TextView qOneAns = (TextView) findViewById(R.id.answer_one);
        qOneAns.setVisibility(View.INVISIBLE);
        TextView qTwoAns = (TextView) findViewById(R.id.answer_two);
        qTwoAns.setVisibility(View.INVISIBLE);
        TextView qThreeAns = (TextView) findViewById(R.id.answer_three);
        qThreeAns.setVisibility(View.INVISIBLE);
        TextView qFourAns = (TextView) findViewById(R.id.answer_four);
        qFourAns.setVisibility(View.INVISIBLE);
        TextView qFiveAns = (TextView) findViewById(R.id.answer_five);
        qFiveAns.setVisibility(View.INVISIBLE);
        TextView qSixAns = (TextView) findViewById(R.id.answer_six);
        qSixAns.setVisibility(View.INVISIBLE);
        TextView qSevenAns = (TextView) findViewById(R.id.answer_seven);
        qSevenAns.setVisibility(View.INVISIBLE);
        TextView qEightAns = (TextView) findViewById(R.id.answer_eight);
        qEightAns.setVisibility(View.INVISIBLE);
        TextView qNineAns = (TextView) findViewById(R.id.answer_nine);
        qNineAns.setVisibility(View.INVISIBLE);
        TextView ten = (TextView) findViewById(R.id.answer_ten);
        ten.setVisibility(View.INVISIBLE);
    }


}
