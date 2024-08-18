package com.example.labreportmp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labreportmp.adapters.StudentAdapter;
import com.example.labreportmp.models.StudentModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerDemo extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo);
        recyclerView = findViewById(R.id.mero_recycler);
        List<StudentModel> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            students.add(new StudentModel("Student " + i));
        }

        StudentAdapter adapter = new StudentAdapter(students);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}