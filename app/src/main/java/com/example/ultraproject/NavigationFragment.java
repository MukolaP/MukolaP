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

public class NavigationFragment extends Fragment implements NavigationToFragment {

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

        navigation(button_colorHelper);
        navigation(button_calculator);

        listView = view.findViewById(R.id.listview);
        EditText editText = view.findViewById(R.id.text_search);
        initList();
        listView.setVisibility(View.INVISIBLE);

        editText.addTextChangedListener(new TextWatcher() {

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
        items = new String[]{"Calculator", "Color helper"};
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(getContext(), R.layout.list_item, R.id.text_item, listItems);
        listView.setAdapter(adapter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public final void navigation(Button button) {
        button.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (view.getId()) {
                case R.id.bt_calculator:
                    transaction.setReorderingAllowed(true);
                    transaction.replace(R.id.MainActivity, Calculator.class, null);
                    transaction.commit();
                    break;
                case R.id.bt_color_helper:
                    transaction.setReorderingAllowed(true);
                    transaction.replace(R.id.MainActivity, CHRelatedFragment.class, null);
                    transaction.commit();
                    break;
            }
        });
    }
}

