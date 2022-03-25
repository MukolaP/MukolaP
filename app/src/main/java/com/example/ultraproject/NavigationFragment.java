package com.example.ultraproject;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import com.example.ultraproject.ColorHelper.ColorHelperActivity;
import com.example.ultraproject.Notes.NotesFragment;
import com.example.ultraproject.Search.Search;

import java.util.ArrayList;
import java.util.Arrays;

public class NavigationFragment extends Fragment {

    private final Search search = new Search();

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

        String[] items = new String[]{"Calculator", "Color Helper", "Notes"};
        ArrayList<String> listItems = new ArrayList<>(Arrays.asList(items));

        search.Search(getContext(), listView, editText_search, listItems);


        listView.setOnItemClickListener((parent, view1, position, id) -> navigation(position));

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
                Intent intent = new Intent(this.getContext(), ColorHelperActivity.class);
                startActivity(intent);
                break;
            case 2:
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.MainActivity, NotesFragment.class, null);
                transaction.commit();
                break;
        }
    }
}