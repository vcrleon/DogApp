package com.example.c4q.dogapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameView, passwordView;
    private Button submitButton;
    private SharedPreferences login;
    private static final String SHARED_PREF_KEY = "userCredentials";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUpViews();
        login = getApplicationContext().getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = login.edit();

                String username = usernameView.getText().toString();
                String password = passwordView.getText().toString();

                if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
                    usernameView.setError(getString(R.string.error_username));
                    passwordView.setError(getString(R.string.error_password));
                } else {

                    if (username.equals(password) || username.contains(password)) { //add containsUsername method
                        passwordView.setError("password cannot contain username");
                    } else {
                        //save using shared prefs & launch BreedsActivity
                        editor.putString("username", usernameView.getText().toString());//null
                        editor.putString("password", passwordView.getText().toString());
                        Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), BreedsActivity.class);
                        startActivity(intent);

                    }
                }
            }
        });

    }

    private void setUpViews() {
        usernameView = findViewById(R.id.username_edittext);
        passwordView = findViewById(R.id.password_edittext);
        submitButton = findViewById(R.id.submit_button);
    }

//    public boolean containsUsername(String password) {
//        for (int i = 0; i < password.length(); i++) {
//            if(password.charAt(i) == )
//        }
//
//        return false;
//    }


}
