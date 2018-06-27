package com.example.android.educationalquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class welcome extends AppCompatActivity {
    EditText usernameid;

    final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void login(View view) {
        usernameid = (EditText) findViewById(R.id.usernameid);
        String usernameget = usernameid.getText().toString();
        if(usernameget != null && !usernameget.trim().isEmpty()) {
            Intent intent = new Intent(this, settingup.class);
            intent.putExtra("USERNAME", usernameget);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please type in your username", Toast.LENGTH_SHORT).show();
        }
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
