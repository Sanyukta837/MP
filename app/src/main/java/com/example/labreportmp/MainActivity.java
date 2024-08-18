package com.example.labreportmp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email_input);
        password = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(v -> {
            String emailText =  email.getText().toString();
            String passwordText = password.getText().toString();

            if(emailText.equals("admin@gmail.com") && passwordText.equals("admin")){
                Toast.makeText(getApplicationContext(),"Logged in successfully", Toast.LENGTH_LONG).show();
            } else{
                Toast.makeText(getApplicationContext(),"Invalid Login Credentials", Toast.LENGTH_LONG).show();
            }

        });

    }
}










