package com.example.android.educationalquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class total extends AppCompatActivity {
    int score;
    String usernameid;
    String choosevalue;
    String choosevalue2;
    String choosevalue3;
    String choosevalue4;
    String choosevalue5;
    String rightanswer;
    String rightanswer2;
    String rightanswer3;
    String rightanswer4;
    String rightanswer5;

    final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        /**
         * getting the @usernameid, @choosevalue and @score which we passed through intent
         */

        choosevalue = getIntent().getStringExtra("CHOOSE");
        choosevalue2 = getIntent().getStringExtra("CHOOSE2");
        choosevalue3 = getIntent().getStringExtra("CHOOSE3");
        choosevalue4 = getIntent().getStringExtra("CHOOSE4");
        choosevalue5 = getIntent().getStringExtra("CHOOSE5");


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
        rightanswer5 = getIntent().getStringExtra("ANSWER5");

        if(score == 3) {
            TextView rating = (TextView) findViewById(R.id.rating_text);
            rating.setText("You tried");
            TextView username = (TextView) findViewById(R.id.get_username);
            username.setText(usernameid);
            TextView ranking = (TextView) findViewById(R.id.ranking);
            ranking.setText("Your Score is " + score);
            Toast.makeText(this, "Your Score is " + score, Toast.LENGTH_SHORT).show();
        } else if(score <= 2) {
            TextView rating = (TextView) findViewById(R.id.rating_text);
            rating.setText("Very Bad");
            TextView username = (TextView) findViewById(R.id.get_username);
            username.setText(usernameid);
            TextView ranking = (TextView) findViewById(R.id.ranking);
            ranking.setText("Your Score is " + score);
            Toast.makeText(this, "Your Score is " + score, Toast.LENGTH_SHORT).show();
        } else {
            TextView rating = (TextView) findViewById(R.id.rating_text);
            rating.setText("Hurray");
            TextView username = (TextView) findViewById(R.id.get_username);
            username.setText(usernameid);
            TextView ranking = (TextView) findViewById(R.id.ranking);
            ranking.setText("Your Score is " + score);
            Toast.makeText(this, "Your Score is " + score, Toast.LENGTH_SHORT).show();
        }
    }

    public void submit(View view) {
        Intent button1 = new Intent(this, answers.class);
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

    boolean twice = false;
    @Override
    public void onBackPressed() {

        Log.d(TAG, "click");

        if( twice == true) {
            Intent intent =  new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
        twice = true;
        Log.d(TAG, "twice: " + twice);

        Toast.makeText(this, "Please press back again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
                Log.d(TAG, "twice: " + twice);
            }
        }, 3000);
    }
}
