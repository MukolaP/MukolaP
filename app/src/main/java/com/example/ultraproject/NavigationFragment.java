package com.example.ultraproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.ultraproject.Calculator.Calculator;
import com.example.ultraproject.ColorHelper.CHRelatedFragment;
import com.example.ultraproject.Notes.NotesFragment;

public class NavigationFragment extends Fragment {

    private String[] items;
    private ArrayList<String> listItems;
    private ArrayAdapter<String> adapter;
    private ListView listView;

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

        listView = view.findViewById(R.id.listview_main);
        EditText editText_search = view.findViewById(R.id.text_search);
        initList();

        listView.setOnItemClickListener((parent, view1, position, id) -> navigation(position));
        listView.setVisibility(View.INVISIBLE);

        editText_search.addTextChangedListener(new TextWatcher() {

            @Override
            public final void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public final void onTextChanged(CharSequence s, int start, int before, int count) {
                listView.setVisibility(View.VISIBLE);
                if (s.toString().equals("")) {
                    initList();
                    listView.setVisibility(View.INVISIBLE);
                } else {
                    searchItem(s.toString());
                }
            }

            @Override
            public final void afterTextChanged(Editable s) {
            }
        });

        return view;
    }

    public final void searchItem(String textToSearch) {
        for (String item : items) {
            String textToSearch1 = textToSearch.toLowerCase();
            if (!item.toLowerCase().contains(textToSearch1)) {
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public final void initList() {
        items = new String[]{"Calculator", "Color helper", "Notes"};
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(getContext(), R.layout.list_item_main, R.id.text_item_main, listItems);
        listView.setAdapter(adapter);
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