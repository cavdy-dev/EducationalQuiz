package com.example.android.educationalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class php3 extends AppCompatActivity {
    int score;
    TextView get_usernameid;
    CheckBox getanswer;
    String usernameid;
    String choosevalue;
    String choosevalue2;
    String choosevalue3;
    String rightanswer;
    String rightanswer2;
    CheckBox correctanswer;
    String rightanswer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php3);

        /**
         * getting the @usernameid, @choosevalue and @score which we passed through intent
         */
        get_usernameid = (TextView) findViewById(R.id.get_username);
        get_usernameid.setText(getIntent().getStringExtra("USERNAME"));

        choosevalue = getIntent().getStringExtra("CHOOSE");
        choosevalue2 = getIntent().getStringExtra("CHOOSE2");

        Intent scoreintent = getIntent();
        score = scoreintent.getIntExtra("SCORE", 0);

        /**
         * sending the intent data from @usernameid to another activity
         */
        usernameid = getIntent().getStringExtra("USERNAME");
        rightanswer = getIntent().getStringExtra("ANSWER");
        rightanswer2 = getIntent().getStringExtra("ANSWER2");

        correctanswer = (CheckBox) findViewById(R.id.checkbox1);
        rightanswer3 = correctanswer.getText().toString();
    }

    public void submit(View view) {
        CheckBox ans1 = (CheckBox) findViewById(R.id.checkbox1);
        boolean ansone = ans1.isChecked();
        CheckBox ans2 = (CheckBox) findViewById(R.id.checkbox2);
        boolean anstwo = ans2.isChecked();
        CheckBox ans3 = (CheckBox) findViewById(R.id.checkbox3);
        boolean ansthree = ans3.isChecked();

        if(ansone == true) {
            score = score + 1;
            getanswer = (CheckBox) findViewById(R.id.checkbox1);
            choosevalue3 = getanswer.getText().toString();
            Intent button2 = new Intent(this, php4.class);
            button2.putExtra("USERNAME", usernameid);
            button2.putExtra("SCORE", score);
            button2.putExtra("CHOOSE", choosevalue);
            button2.putExtra("CHOOSE2", choosevalue2);
            button2.putExtra("CHOOSE3", choosevalue3);
            button2.putExtra("ANSWER", rightanswer);
            button2.putExtra("ANSWER2", rightanswer2);
            button2.putExtra("ANSWER3", rightanswer3);
            startActivity(button2);
        } else if(anstwo == true) {
            getanswer = (CheckBox) findViewById(R.id.checkbox2);
            choosevalue3 = getanswer.getText().toString();
            score = score + 0;
            Intent button3 = new Intent(this, php4.class);
            button3.putExtra("USERNAME", usernameid);
            button3.putExtra("SCORE", score);
            button3.putExtra("CHOOSE", choosevalue);
            button3.putExtra("CHOOSE2", choosevalue2);
            button3.putExtra("CHOOSE3", choosevalue3);
            button3.putExtra("ANSWER", rightanswer);
            button3.putExtra("ANSWER2", rightanswer2);
            button3.putExtra("ANSWER3", rightanswer3);
            startActivity(button3);
        } else if(ansthree == true) {
            score = score + 0;
            getanswer = (CheckBox) findViewById(R.id.checkbox3);
            choosevalue3 = getanswer.getText().toString();
            Intent button1 = new Intent(this, php4.class);
            button1.putExtra("USERNAME", usernameid);
            button1.putExtra("SCORE", score);
            button1.putExtra("CHOOSE", choosevalue);
            button1.putExtra("CHOOSE2", choosevalue2);
            button1.putExtra("CHOOSE3", choosevalue3);
            button1.putExtra("ANSWER", rightanswer);
            button1.putExtra("ANSWER2", rightanswer2);
            button1.putExtra("ANSWER3", rightanswer3);
            startActivity(button1);
        } else {
            Toast.makeText(this, "Please Choose One", Toast.LENGTH_SHORT).show();
        }
    }

    public void home(View view) {
        Intent home = new Intent(this, choose.class);
        home.putExtra("USERNAME", usernameid);
        startActivity(home);
    }

    public void skip(View view) {
        choosevalue3 = "You skipped this question";
        score = score + 0;
        Intent skip = new Intent(this, php4.class);
        skip.putExtra("USERNAME", usernameid);
        skip.putExtra("SCORE", score);
        skip.putExtra("CHOOSE", choosevalue);
        skip.putExtra("CHOOSE2", choosevalue2);
        skip.putExtra("CHOOSE3", choosevalue3);
        skip.putExtra("ANSWER", rightanswer);
        skip.putExtra("ANSWER2", rightanswer2);
        skip.putExtra("ANSWER3", rightanswer3);
        startActivity(skip);
    }
}
