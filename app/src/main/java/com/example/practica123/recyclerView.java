package com.example.practica123;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        ArrayList<String>tareas = new ArrayList<>();

        for(int item = 0; item<=10;item++){
            tareas.add("CAPITAN AMÉRICA " + item);

        }

        TareasRecyclerViewAdapter adapter = new TareasRecyclerViewAdapter(this, tareas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
