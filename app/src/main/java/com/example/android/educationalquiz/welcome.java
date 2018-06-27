package com.example.android.educationalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class welcome extends AppCompatActivity {
    EditText usernameid;

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
}
