package com.example.c4q.dogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText usernameView, passwordView;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUpViews();


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameView.getText().toString();
                String password = passwordView.getText().toString();

                if(TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
                    usernameView.setError("enter username");
                    passwordView.setError("enter password");
                }
            }
        });

    }


    private void setUpViews() {
        usernameView = findViewById(R.id.username_edittext);
        passwordView = findViewById(R.id.password_edittext);
        submitButton = findViewById(R.id.submit_button);
    }



}
