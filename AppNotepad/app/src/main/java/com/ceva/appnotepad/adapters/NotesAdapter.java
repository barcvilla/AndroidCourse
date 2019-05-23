package com.ceva.appnotepad.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ceva.appnotepad.R;
import com.ceva.appnotepad.domain.Note;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder>{

    Context context;
    List<Note> noteList;

    public  NotesAdapter(Context context, List<Note> noteList)
    {
        this.context = context;
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // definimos la vista
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.id.setText(String.valueOf(noteList.get(i).getId()));
        viewHolder.title.setText(noteList.get(i).getTitle());
        viewHolder.body.setText(noteList.get(i).getBody());
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteList.remove(i);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    //creamos clase para mantener la vista
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        CardView cardView;
        TextView id;
        TextView title;
        TextView body;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardview);
            id = (TextView)itemView.findViewById(R.id.id);
            title = (TextView)itemView.findViewById(R.id.title);
            body = (TextView)itemView.findViewById(R.id.body);
            imageView = (ImageView) itemView.findViewById(R.id.trash);
        }
    }
}
