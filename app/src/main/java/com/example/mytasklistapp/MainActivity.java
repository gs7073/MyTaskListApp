package com.example.mytasklistapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> taskList;
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = new ArrayList<>();
        EditText etNewTask = findViewById(R.id.etNewTask);
        Button btnAddTask = findViewById(R.id.btnAddTask);
        RecyclerView rvTasks = findViewById(R.id.rvTasks);

        adapter = new TaskAdapter(taskList);
        rvTasks.setAdapter(adapter);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));

        btnAddTask.setOnClickListener(v -> {
            String title = etNewTask.getText().toString();
            if (!title.isEmpty()) {
                taskList.add(new Task(title));
                adapter.notifyItemInserted(taskList.size() - 1);
                etNewTask.setText("");
            }
        });
    }
}