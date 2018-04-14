package com.example.abhii.notify;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    Context context;
    List <Note> notes=new ArrayList<>();

    public NotesAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(notes.get(position).getTitle());
        holder.content.setText(notes.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        if(notes.isEmpty()) {
            return 0;
        }
        else{
            return (int)notes.size();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView content;
        public ViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.note_title);
            content=itemView.findViewById(R.id.note_content);

        }
    }
}
