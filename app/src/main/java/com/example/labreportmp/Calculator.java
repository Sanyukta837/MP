package com.example.labreportmp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculator extends AppCompatActivity {
    EditText num1;
    EditText num2;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        num1 = findViewById(R.id.number1);
        num2 = findViewById(R.id.number2);
        addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(v -> {
            int n1 = Integer.parseInt(num1.getText().toString());
            int n2 = Integer.parseInt(num2.getText().toString());
            int n3 = n1 + n2;

            Intent intent = new Intent(getApplicationContext(), CalculatorActivity2.class);
            intent.putExtra("result", n3);
            startActivity(intent);


        });

    }
}










