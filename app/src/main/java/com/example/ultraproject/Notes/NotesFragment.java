package com.example.ultraproject.Notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ultraproject.NavigationFragment;
import com.example.ultraproject.R;
import com.example.ultraproject.Search.SearchController;

import java.util.ArrayList;

public class NotesFragment extends Fragment {

    private final SearchController searchController = new SearchController();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_notes, null);

        Button back_to_main = view.findViewById(R.id.back_notes);
        navigation(back_to_main, 0);

        Button bt_newNotes = view.findViewById(R.id.bt_newNotes);
        navigation(bt_newNotes, 1);

        ListView listView = view.findViewById(R.id.listview_notes);
        EditText editText_search = view.findViewById(R.id.text_search_notes);

        ArrayList<String> listItems = NotesController.getArrayList();

        searchController.Search(getContext(), listView, editText_search, listItems);

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    public final void navigation(Button button, int pos) {
        button.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            switch (pos) {
                case (0):
                    transaction.setReorderingAllowed(true);
                    transaction.replace(R.id.MainActivity, NavigationFragment.class, null);
                    transaction.commit();
                    break;
                case (1):
                    transaction.setReorderingAllowed(true);
                    transaction.replace(R.id.MainActivity, WriteNotesFragment.class, null);
                    transaction.commit();
                    break;
            }
        });
    }

    public void transaction(int pos) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        switch (pos) {
            case 0:
            case 1:
            case 2:
                break;
        }
    }
}