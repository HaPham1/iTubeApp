package com.example.itubeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.itubeapp.data.DatabaseHelper;
import com.example.itubeapp.model.User;

public class SignupActivity extends AppCompatActivity {
    EditText fullnameText, usernameText, passText, confirmpassText;
    Button createBtn;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fullnameText = findViewById(R.id.fullnameText);
        usernameText = findViewById(R.id.usernameText);
        passText = findViewById(R.id.pass1Text);
        confirmpassText = findViewById(R.id.pass1confirmText);
        createBtn = findViewById(R.id.addBtn);

        db = new DatabaseHelper(this);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = fullnameText.getText().toString();
                String username = usernameText.getText().toString();
                String password = passText.getText().toString();
                String confirmPassword = confirmpassText.getText().toString();

                if (password.equals(confirmPassword))
                {
                    long result = db.insertUser(new User(fullname, username, password));
                    if (result > 0)
                    {
                        Toast.makeText(SignupActivity.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                        Intent addIntent = new Intent(SignupActivity.this, MainActivity.class);
                        startActivity(addIntent);
                    }
                    else {
                        Toast.makeText(SignupActivity.this, "Registration error!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(SignupActivity.this, "Two passwords do not match!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}