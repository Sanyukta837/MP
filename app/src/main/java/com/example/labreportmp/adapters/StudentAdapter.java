package com.example.labreportmp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labreportmp.R;
import com.example.labreportmp.models.StudentModel;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    List<StudentModel> studentsList;

    public StudentAdapter(List<StudentModel> studentsList){
        this.studentsList = studentsList;
    }
    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_recycler_row,parent,false);
        return new StudentAdapter.StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int position) {
        StudentModel student = studentsList.get(position);
        holder.studentText.setText(student.getStudentName());
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }



    public class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView studentText;
        public StudentViewHolder(@NonNull View itemView){
            super(itemView);
            studentText = itemView.findViewById(R.id.student_name);
        }
    }
}
