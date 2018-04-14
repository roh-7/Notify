package com.example.abhii.notify;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    FloatingActionButton fab;
    List<Note> notes=new ArrayList<>();
    NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        fab=findViewById(R.id.fab);
        rv.setLayoutManager(new LinearLayoutManager(this));
        init();
        adapter = new NotesAdapter(this,notes);
        rv.setAdapter(adapter);
    }
    public void init(){
    notes.add(new Note("Happy Birthday" , "To you"));
    notes.add(new Note("Happy Birthday" , "To you"));
    notes.add(new Note("Happy Birthday" , "To you"));
    notes.add(new Note("Happy Birthday" , "To you"));
    notes.add(new Note("Happy Birthday" , "To you"));
    notes.add(new Note("Happy Birthday" , "To you"));
    notes.add(new Note("Happy Birthday" , "To you"));
    notes.add(new Note("Happy Birthday" , "To you"));
    notes.add(new Note("Happy Birthday" , "To you"));

    }
}
