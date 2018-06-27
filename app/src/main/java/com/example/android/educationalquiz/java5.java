package com.example.android.educationalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class java5 extends AppCompatActivity {
    int score;
    TextView get_usernameid;
    String usernameid;
    String choosevalue;
    String choosevalue2;
    String choosevalue3;
    String choosevalue4;
    String choosevalue5;
    String edittext;
    String rightanswer;
    String rightanswer2;
    String rightanswer3;
    String rightanswer4;
    String rightanswer5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java5);

        /**
         * getting the @usernameid, @choosevalue and @score which we passed through intent
         */
        get_usernameid = (TextView) findViewById(R.id.get_username);
        get_usernameid.setText(getIntent().getStringExtra("USERNAME"));

        choosevalue = getIntent().getStringExtra("CHOOSE");
        choosevalue2 = getIntent().getStringExtra("CHOOSE2");
        choosevalue3 = getIntent().getStringExtra("CHOOSE3");
        choosevalue4 = getIntent().getStringExtra("CHOOSE4");

        Intent scoreintent = getIntent();
        score = scoreintent.getIntExtra("SCORE", 0);

        /**
         * sending the intent data from @usernameid to another activity
         */
        usernameid = getIntent().getStringExtra("USERNAME");
        rightanswer = getIntent().getStringExtra("ANSWER");
        rightanswer2 = getIntent().getStringExtra("ANSWER2");
        rightanswer3 = getIntent().getStringExtra("ANSWER3");
        rightanswer4 = getIntent().getStringExtra("ANSWER4");
        rightanswer5 = "boolean";
    }

    public void submit(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_box);
        edittext = editText.getText().toString().toLowerCase();
        if(edittext != null && !edittext.trim().isEmpty()) {
            if (edittext.contains("boolean")) {
                choosevalue5 = edittext;
                score = score + 1;
                Intent button2 = new Intent(this, total.class);
                button2.putExtra("USERNAME", usernameid);
                button2.putExtra("SCORE", score);
                button2.putExtra("CHOOSE", choosevalue);
                button2.putExtra("CHOOSE2", choosevalue2);
                button2.putExtra("CHOOSE3", choosevalue3);
                button2.putExtra("CHOOSE4", choosevalue4);
                button2.putExtra("CHOOSE5", choosevalue5);
                button2.putExtra("ANSWER", rightanswer);
                button2.putExtra("ANSWER2", rightanswer2);
                button2.putExtra("ANSWER3", rightanswer3);
                button2.putExtra("ANSWER4", rightanswer4);
                button2.putExtra("ANSWER5", rightanswer5);
                startActivity(button2);
            } else {
                score = score + 0;
                choosevalue5 = edittext;
                Intent button1 = new Intent(this, total.class);
                button1.putExtra("USERNAME", usernameid);
                button1.putExtra("SCORE", score);
                button1.putExtra("CHOOSE", choosevalue);
                button1.putExtra("CHOOSE2", choosevalue2);
                button1.putExtra("CHOOSE3", choosevalue3);
                button1.putExtra("CHOOSE4", choosevalue4);
                button1.putExtra("CHOOSE5", choosevalue5);
                button1.putExtra("ANSWER", rightanswer);
                button1.putExtra("ANSWER2", rightanswer2);
                button1.putExtra("ANSWER3", rightanswer3);
                button1.putExtra("ANSWER4", rightanswer4);
                button1.putExtra("ANSWER5", rightanswer5);
                startActivity(button1);
            }
        } else {
            Toast.makeText(this, "Please type in the answer", Toast.LENGTH_SHORT).show();
        }
    }

    public void home(View view) {
        Intent home = new Intent(this, choose.class);
        home.putExtra("USERNAME", usernameid);
        startActivity(home);
    }

    public void skip(View view) {
        choosevalue5 = "You skipped this question";
        score = score + 0;
        Intent skip = new Intent(this, total.class);
        skip.putExtra("USERNAME", usernameid);
        skip.putExtra("SCORE", score);
        skip.putExtra("CHOOSE", choosevalue);
        skip.putExtra("CHOOSE2", choosevalue2);
        skip.putExtra("CHOOSE3", choosevalue3);
        skip.putExtra("CHOOSE4", choosevalue4);
        skip.putExtra("CHOOSE5", choosevalue5);
        skip.putExtra("ANSWER", rightanswer);
        skip.putExtra("ANSWER2", rightanswer2);
        skip.putExtra("ANSWER3", rightanswer3);
        skip.putExtra("ANSWER4", rightanswer4);
        skip.putExtra("ANSWER5", rightanswer5);
        startActivity(skip);
    }
}
