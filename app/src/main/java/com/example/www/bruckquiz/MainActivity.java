package com.example.www.bruckquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Initialize variables for storing the answers for the RadioGroup questions
    String answerQuestionOne;
    String answerQuestionTwo;
    String answerQuestionThree;
    String answerQuestionFour;
    String answerQuestionFive;
    String answerQuestionSix;

    // int variable for correct answers
    int numberOfCorrectAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Get user answers for questions, gets triggered by pressing the FAB
    public void getUserAnswers(View view) {

        // Question One
        RadioGroup radioGroupQuestionOne = (RadioGroup) findViewById(R.id.radioGroupQuestion1);
        answerQuestionOne = Integer.toString(getRadioGroupIndex(radioGroupQuestionOne));

        // Question Two
        RadioGroup radioGroupQuestionTwo = (RadioGroup) findViewById(R.id.radioGroupQuestion2);
        answerQuestionTwo = Integer.toString(getRadioGroupIndex(radioGroupQuestionTwo));

        // Question Three
        EditText editTextQuestionThree = (EditText) findViewById(R.id.TextQuestion3);
        answerQuestionThree = editTextQuestionThree.getText().toString().trim();

        // Question Four
        CheckBox checkBoxQuestion4a = (CheckBox) findViewById(R.id.cbQuestion4a);
        answerQuestionFour = String.valueOf((checkBoxQuestion4a.isChecked()) ? 1 : 0);
        CheckBox checkBoxQuestion4b = (CheckBox) findViewById(R.id.cbQuestion4b);
        answerQuestionFour = answerQuestionFour + String.valueOf((checkBoxQuestion4b.isChecked()) ? 1 : 0);
        CheckBox checkBoxQuestion4c = (CheckBox) findViewById(R.id.cbQuestion4c);
        answerQuestionFour = answerQuestionFour + String.valueOf((checkBoxQuestion4c.isChecked()) ? 1 : 0);
        CheckBox checkBoxQuestion4d = (CheckBox) findViewById(R.id.cbQuestion4d);
        answerQuestionFour = answerQuestionFour + String.valueOf((checkBoxQuestion4d.isChecked()) ? 1 : 0);
        CheckBox checkBoxQuestion4e = (CheckBox) findViewById(R.id.cbQuestion4e);
        answerQuestionFour = answerQuestionFour + String.valueOf((checkBoxQuestion4e.isChecked()) ? 1 : 0);
        CheckBox checkBoxQuestion4f = (CheckBox) findViewById(R.id.cbQuestion4f);
        answerQuestionFour = answerQuestionFour + String.valueOf((checkBoxQuestion4f.isChecked()) ? 1 : 0);

        // Question Five
        EditText editTextQuestionFive = (EditText) findViewById(R.id.TextQuestion5);
        answerQuestionFive = editTextQuestionFive.getText().toString().trim();

        // Question Six
        CheckBox checkBoxQuestion6a = (CheckBox) findViewById(R.id.cbQuestion6a);
        answerQuestionSix = String.valueOf((checkBoxQuestion6a.isChecked()) ? 1 : 0);
        CheckBox checkBoxQuestion6b = (CheckBox) findViewById(R.id.cbQuestion6b);
        answerQuestionSix = answerQuestionSix + String.valueOf((checkBoxQuestion6b.isChecked()) ? 1 : 0);
        CheckBox checkBoxQuestion6c = (CheckBox) findViewById(R.id.cbQuestion6c);
        answerQuestionSix = answerQuestionSix + String.valueOf((checkBoxQuestion6c.isChecked()) ? 1 : 0);
        CheckBox checkBoxQuestion6d = (CheckBox) findViewById(R.id.cbQuestion6d);
        answerQuestionSix = answerQuestionSix + String.valueOf((checkBoxQuestion6d.isChecked()) ? 1 : 0);
        CheckBox checkBoxQuestion6e = (CheckBox) findViewById(R.id.cbQuestion6e);
        answerQuestionSix = answerQuestionSix + String.valueOf((checkBoxQuestion6e.isChecked()) ? 1 : 0);
        CheckBox checkBoxQuestion6f = (CheckBox) findViewById(R.id.cbQuestion6f);
        answerQuestionSix = answerQuestionSix + String.valueOf((checkBoxQuestion6f.isChecked()) ? 1 : 0);

        //The if statement checks if all questions were answered
        if (!answerQuestionOne.equals("-1") && !answerQuestionTwo.equals("-1") && !answerQuestionThree.isEmpty() && !answerQuestionFour.equals("000000") && !answerQuestionFive.isEmpty() && !answerQuestionSix.equals("000000")) {

            //Call method that check if the answers are correct
            checkCorrectAnswers();
            if (numberOfCorrectAnswers == 6) {
                // Creates toast output - Winner
                Toast.makeText(getApplicationContext(),
                        getString(R.string.answersAllCorrect),
                        Toast.LENGTH_SHORT).show();

            } else {
                // Creates toast output - Show correct answers
                Toast.makeText(getApplicationContext(),
                        getString(R.string.answersPartlyCorrectA) + " " + numberOfCorrectAnswers + " " + getString(R.string.answersPartlyCorrectB),
                        Toast.LENGTH_SHORT).show();
            }
            // Reset counter for correct answers
            numberOfCorrectAnswers = 0;
        } else {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.answersMissing),
                    Toast.LENGTH_SHORT).show();
        }
    }

    // method to check for correct answers
    private void checkCorrectAnswers() {
        // First radio button pressed
        if (answerQuestionOne.equals("0")) {
            numberOfCorrectAnswers += 1;
        }
        // Second Radio button pressed
        if (answerQuestionTwo.equals("2")) {
            numberOfCorrectAnswers += 1;
        }
        // A tough one :) - the year is 1792
        if (answerQuestionThree.equals("1792")) {
            numberOfCorrectAnswers += 1;
        }
        // First three checkboxes are checked
        if (answerQuestionFour.equals("111000")) {
            numberOfCorrectAnswers += 1;
        }
        // The lovely town of Oberaich
        if (answerQuestionFive.equals("Oberaich") || answerQuestionFive.equals("oberaich")) {
            numberOfCorrectAnswers += 1;
        }
        // Boxes 1, 3 and 4 are checked
        if (answerQuestionSix.equals("101100")) {
            numberOfCorrectAnswers += 1;
        }
    }

    // find index of selected RadioButton in RadioGroup, returns value as int
    private int getRadioGroupIndex(RadioGroup radioGroup) {
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        return radioGroup.indexOfChild(radioButton);
    }
}