package com.example.ultraproject.Notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ultraproject.R;

public class NotesReviewFragment extends Fragment {

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_notes_review, null);

        Button back_notes = view.findViewById(R.id.back_ToNotesReview);
        navigation(back_notes);

        TextView themeNotes = view.findViewById(R.id.themes_reviewNotes);
        TextView bodyNotes = view.findViewById(R.id.body_reviewNotes);

        themeNotes.setText(" Тема - " + NotesModel.getListThemes().get(NotesModel.getPos()));
        bodyNotes.setText(NotesModel.getListBody().get(NotesModel.getPos()));

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    private void navigation(Button button) {
        button.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.MainActivity, NotesFragment.class, null);
            transaction.commit();
        });
    }
}