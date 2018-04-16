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



		rv.setLayoutManager(new LinearLayoutManager(this));
		init();
		adapter = new NotesAdapter(this, notes);
		rv.setAdapter(adapter);

	}


	public void init()
	{
		/*notes.add(new Note("Title 1", "Content 1"));
		notes.add(new Note("Title 2", "Content 2"));
		notes.add(new Note("Title 3", "Content 3"));
		notes.add(new Note("Title 4", "Content 4"));
		notes.add(new Note("Title 5", "Content 5"));
		notes.add(new Note("Title 6", "Content 6"));
		notes.add(new Note("Title 7", "Content 7"));
		notes.add(new Note("Title 8", "Content 8"));
		notes.add(new Note("Title 9", "Content 9"));*/

		ref = database.getReference("/notes");

		ref.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot)
			{
				for (DataSnapshot itemSnapshot:dataSnapshot.getChildren())
				{
					Log.v("TAG",itemSnapshot.toString());
					Note note = itemSnapshot.getValue(Note.class);
					notes.add(note);
					adapter.notifyDataSetChanged();
				}
			}

			@Override
			public void onCancelled(DatabaseError databaseError)
			{

			}
		});

	}
}
