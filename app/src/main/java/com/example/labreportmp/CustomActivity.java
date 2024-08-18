package com.example.labreportmp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomActivity extends AppCompatActivity {
    Button clickMeButton;
    Button loginButton;
    TextView email;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        clickMeButton = findViewById(R.id.click_me);
        clickMeButton.setOnClickListener(v -> {
            showCustomDialog();
        });
    }


    public void showCustomDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        email = dialog.findViewById(R.id.email_in);
        password = dialog.findViewById(R.id.password_in);
        loginButton = dialog.findViewById(R.id.login_but);

        loginButton.setOnClickListener(v -> {
            String emailText =  email.getText().toString();
            String passwordText = password.getText().toString();

            if(emailText.equals("admin@gmail.com") && passwordText.equals("admin")){
                Toast.makeText(getApplicationContext(),"Logged in successfully", Toast.LENGTH_LONG).show();
            } else{
                Toast.makeText(getApplicationContext(),"Invalid Login Credentials", Toast.LENGTH_LONG).show();
            }
        });

        dialog.getWindow().setLayout(800,1000);
        dialog.show();
    }











}