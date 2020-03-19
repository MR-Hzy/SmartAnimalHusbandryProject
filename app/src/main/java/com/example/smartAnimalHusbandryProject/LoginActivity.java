package com.example.smartAnimalHusbandryProject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    final String USER = "user";
    final String ADMIN = "admin";
    final String USER_PASSWORD = "admin123123";
    final String ADMIN_PASSWORD = "admin123123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText usernameEditText = findViewById(R.id.login_user);
        final EditText passwordEditText = findViewById(R.id.login_password);
        final Button loginButton = findViewById(R.id.login_button);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginButton.setEnabled(passwordEditText.getText().length() > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                switch(usernameEditText.getText().toString()){
                    case USER:
                        if(passwordEditText.getText().toString().equals(USER_PASSWORD)) {
                            Intent intent = new Intent(LoginActivity.this,UserLoginActivity.class);
                            startActivity(intent);
                            setResult(Activity.RESULT_OK);
                            finish();
                            break;
                        }
                    case ADMIN:
                        if(passwordEditText.getText().toString().equals(ADMIN_PASSWORD)) {
                            Intent intent = new Intent(LoginActivity.this,AdminLoginActivity.class);
                            startActivity(intent);
                            setResult(Activity.RESULT_OK);
                            finish();
                            break;
                        }
                    default:
                        loadingProgressBar.setVisibility(View.GONE);
                        Toast toast=Toast.makeText(LoginActivity.this,"用户名或密码错误，请重新输入",Toast.LENGTH_SHORT );
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                        break;
                }
            }
        });
    }

}
