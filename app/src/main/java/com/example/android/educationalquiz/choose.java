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

public class choose extends AppCompatActivity {
    TextView get_usernameid;
    String usernameid;

    final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        /**
         * getting the @usernameid which we passed through intent
         */
        get_usernameid = (TextView) findViewById(R.id.get_username);
        get_usernameid.setText(getIntent().getStringExtra("USERNAME"));

        /**
         * sending the intent data from @usernameid to another activity
         */
        usernameid = getIntent().getStringExtra("USERNAME");
    }

    public void php(View view) {
        Intent php = new Intent(this, php1.class);
        php.putExtra("USERNAME", usernameid);
        startActivity(php);
    }
    public void java(View view) {
        Intent java = new Intent(this, java.class);
        java.putExtra("USERNAME", usernameid);
        startActivity(java);
    }
    public void javascript(View view) {
        Intent javascript = new Intent(this, javascript.class);
        javascript.putExtra("USERNAME", usernameid);
        startActivity(javascript);
    }
    public void xml(View view) {
        Intent xml = new Intent(this, xml.class);
        xml.putExtra("USERNAME", usernameid);
        startActivity(xml);
    }
    public void tech(View view) {
        Intent tech = new Intent(this, tech.class);
        tech.putExtra("USERNAME", usernameid);
        startActivity(tech);
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
