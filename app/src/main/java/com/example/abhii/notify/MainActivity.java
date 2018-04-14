package com.example.abhii.notify;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
	RecyclerView rv;
	FloatingActionButton fab;
	List<Note> notes = new ArrayList<>();
	NotesAdapter adapter;

	FirebaseDatabase database = FirebaseDatabase.getInstance();
	DatabaseReference ref;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rv = findViewById(R.id.rv);
		fab = findViewById(R.id.fab);

		ref = database.getReference("/notes");

		ref.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot)
			{
				Log.v("TAG",dataSnapshot.toString());
			}

			@Override
			public void onCancelled(DatabaseError databaseError)
			{

			}
		});

		rv.setLayoutManager(new LinearLayoutManager(this));
		init();
		adapter = new NotesAdapter(this, notes);
		rv.setAdapter(adapter);

	}


	public void init()
	{
		notes.add(new Note("Happy Birthday", "To you"));
		notes.add(new Note("Happy Birthday", "To you"));
		notes.add(new Note("Happy Birthday", "To you"));
		notes.add(new Note("Happy Birthday", "To you"));
		notes.add(new Note("Happy Birthday", "To you"));
		notes.add(new Note("Happy Birthday", "To you"));
		notes.add(new Note("Happy Birthday", "To you"));
		notes.add(new Note("Happy Birthday", "To you"));
		notes.add(new Note("Happy Birthday", "To you"));

	}
}
