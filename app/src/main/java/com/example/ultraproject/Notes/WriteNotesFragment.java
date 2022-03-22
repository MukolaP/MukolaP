package com.example.ultraproject.Notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ultraproject.R;

public class WriteNotesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_write_notes, null);

        Button back_notes = view.findViewById(R.id.back_ToNotes);
        back_notes.setOnClickListener(view1 -> navigation());

        EditText theme_notes = view.findViewById(R.id.theme_notes);
        EditText body_notes = view.findViewById(R.id.body_notes);

        Button button_add = view.findViewById(R.id.bt_notes_add);
        addToNotes(button_add, theme_notes, body_notes);

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    private void navigation() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.MainActivity, NotesFragment.class, null);
        transaction.commit();
    }

    private void addToNotes(Button button, EditText theme_notes, EditText body_notes){
        button.setOnClickListener(view1 -> {
            NotesModel.getListThemes().add(theme_notes.getText().toString());
            NotesModel.getListBody().add(body_notes.getText().toString());
            navigation();
        });
    }
}