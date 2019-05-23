package com.ceva.appnotepad.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ceva.appnotepad.R;
import com.ceva.appnotepad.domain.Note;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    RecyclerView recyclerView;
    List<Note> noteList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_layout, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // el reciclerView es una vista que ubica los elementos en una lista
        recyclerView = (RecyclerView)view.findViewById(R.id.reciclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        initializedData();
    }

    public void initializedData()
    {
        noteList = new ArrayList<>();
        noteList.add(new Note(1, "Nota 1", "Texto para la nota 1"));
        noteList.add(new Note(2, "Nota 2", "Texto para la nota 2"));
        noteList.add(new Note(3, "Nota 3", "Texto para la nota 3"));
        noteList.add(new Note(4, "Nota 4", "Texto para la nota 4"));
        noteList.add(new Note(5, "Nota 5", "Texto para la nota 5"));
        noteList.add(new Note(6, "Nota 6", "Texto para la nota 6"));
        noteList.add(new Note(7, "Nota 7", "Texto para la nota 7"));
        noteList.add(new Note(8, "Nota 8", "Texto para la nota 8"));
        noteList.add(new Note(9, "Nota 9", "Texto para la nota 9"));
        noteList.add(new Note(10, "Nota 10", "Texto para la nota 10"));

    }
}
