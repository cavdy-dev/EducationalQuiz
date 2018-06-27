package com.example.android.educationalquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class xml extends AppCompatActivity {
    int score = 0;
    TextView get_usernameid;
    Button getanswer;
    String usernameid;
    String choosevalue;
    Button correctanswer;
    String rightanswer;

    final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

        /**
         * getting the @usernameid which we passed through intent
         */
        get_usernameid = (TextView) findViewById(R.id.get_username);
        get_usernameid.setText(getIntent().getStringExtra("USERNAME"));

        /**
         * sending the intent data from @usernameid to another activity
         */
        usernameid = getIntent().getStringExtra("USERNAME");
        correctanswer = (Button) findViewById(R.id.button2);
        rightanswer = correctanswer.getText().toString();
    }

    public void button1(View view) {
        score = 0;
        getanswer = (Button) findViewById(R.id.button1);
        choosevalue = getanswer.getText().toString();
        Intent button1 = new Intent(this, xml2.class);
        button1.putExtra("USERNAME", usernameid);
        button1.putExtra("SCORE", score);
        button1.putExtra("CHOOSE", choosevalue);
        button1.putExtra("ANSWER", rightanswer);
        startActivity(button1);
    }

    public void button2(View view) {
        score = score + 1;
        getanswer = (Button) findViewById(R.id.button2);
        choosevalue = getanswer.getText().toString();
        Intent button2 = new Intent(this, xml2.class);
        button2.putExtra("USERNAME", usernameid);
        button2.putExtra("SCORE", score);
        button2.putExtra("CHOOSE", choosevalue);
        button2.putExtra("ANSWER", rightanswer);
        startActivity(button2);
    }

    public void button3(View view) {
        getanswer = (Button) findViewById(R.id.button3);
        choosevalue = getanswer.getText().toString();
        score = 0;
        Intent button3 = new Intent(this, xml2.class);
        button3.putExtra("USERNAME", usernameid);
        button3.putExtra("SCORE", score);
        button3.putExtra("CHOOSE", choosevalue);
        button3.putExtra("ANSWER", rightanswer);
        startActivity(button3);
    }

    public void button4(View view) {
        getanswer = (Button) findViewById(R.id.button4);
        choosevalue = getanswer.getText().toString();
        score = 0;
        Intent button4 = new Intent(this, xml2.class);
        button4.putExtra("USERNAME", usernameid);
        button4.putExtra("SCORE", score);
        button4.putExtra("CHOOSE", choosevalue);
        button4.putExtra("ANSWER", rightanswer);
        startActivity(button4);
    }

    public void home(View view) {
        Intent home = new Intent(this, choose.class);
        home.putExtra("USERNAME", usernameid);
        startActivity(home);
    }

    public void skip(View view) {
        choosevalue = "You skipped this question";
        score = 0;
        Intent skip = new Intent(this, xml2.class);
        skip.putExtra("USERNAME", usernameid);
        skip.putExtra("SCORE", score);
        skip.putExtra("CHOOSE", choosevalue);
        skip.putExtra("ANSWER", rightanswer);
        startActivity(skip);
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
