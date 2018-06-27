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

public class answers extends AppCompatActivity {
    int score;
    TextView get_usernameid;
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
        setContentView(R.layout.activity_answers);
        /**
         * getting the @usernameid, @choosevalue and @score which we passed through intent
         */
        get_usernameid = (TextView) findViewById(R.id.get_username);
        get_usernameid.setText(getIntent().getStringExtra("USERNAME"));

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

        TextView choose1 = (TextView) findViewById(R.id.choose1);
        choose1.setText(choosevalue);
        TextView answer1 = (TextView) findViewById(R.id.ans1);
        answer1.setText(rightanswer);
        TextView choose2 = (TextView) findViewById(R.id.choose2);
        choose2.setText(choosevalue2);
        TextView answer2 = (TextView) findViewById(R.id.ans2);
        answer2.setText(rightanswer2);
        TextView choose3 = (TextView) findViewById(R.id.choose3);
        choose3.setText(choosevalue3);
        TextView answer3 = (TextView) findViewById(R.id.ans3);
        answer3.setText(rightanswer3);
        TextView choose4 = (TextView) findViewById(R.id.choose4);
        choose4.setText(choosevalue4);
        TextView answer4 = (TextView) findViewById(R.id.ans4);
        answer4.setText(rightanswer4);
        TextView choose5 = (TextView) findViewById(R.id.choose5);
        choose5.setText(choosevalue5);
        TextView answer5 = (TextView) findViewById(R.id.ans5);
        answer5.setText(rightanswer5);
    }

    public void home(View view) {
        Intent home = new Intent(this, choose.class);
        home.putExtra("USERNAME", usernameid);
        startActivity(home);
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
