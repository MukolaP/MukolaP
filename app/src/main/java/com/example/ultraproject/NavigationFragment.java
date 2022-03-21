package com.example.ultraproject;

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

import com.example.ultraproject.Calculator.Calculator;
import com.example.ultraproject.ColorHelper.CHRelatedFragment;
import com.example.ultraproject.Notes.NotesFragment;
import com.example.ultraproject.Search.SearchController;

public class NavigationFragment extends Fragment {

    private final SearchController searchController = new SearchController();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_main, null);

        Button button_colorHelper = view.findViewById(R.id.bt_color_helper);
        Button button_calculator = view.findViewById(R.id.bt_calculator);
        Button button_notes = view.findViewById(R.id.bt_notes);

        button_calculator.setOnClickListener(view12 -> navigation(0));
        button_colorHelper.setOnClickListener(view12 -> navigation(1));
        button_notes.setOnClickListener(view12 -> navigation(2));

        ListView listView = view.findViewById(R.id.listview_main);
        EditText editText_search = view.findViewById(R.id.text_search);

        searchController.Search(listView, editText_search, getContext());

        return view;
    }

    public void navigation(int pos) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        switch (pos){
            case 0:
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.MainActivity, Calculator.class, null);
                transaction.commit();
                break;
            case 1:
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.MainActivity, CHRelatedFragment.class, null);
                transaction.commit();
                break;
            case 2:
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.MainActivity, NotesFragment.class, null);
                transaction.commit();
                break;
        }
    }
}