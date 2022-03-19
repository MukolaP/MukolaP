package com.example.ultraproject.Notes;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.ultraproject.NavigationFragment;
import com.example.ultraproject.R;

import java.util.ArrayList;
import java.util.Arrays;

public class NotesFragment extends Fragment {

    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_notes, null);

        Button back_to_main = view.findViewById(R.id.back_notes);
        navigation(back_to_main);

        listView = (ListView) view.findViewById(R.id.listview_notes);
        editText = (EditText) view.findViewById(R.id.text_notes);
        initList();

        listView.setOnItemClickListener((parent, view1, position, id) -> transaction(position));
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
            public void afterTextChanged(Editable editable) {
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

    @SuppressLint("NonConstantResourceId")
    public final void navigation(Button button) {
        button.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            if (view.getId() == R.id.back_notes) {
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.MainActivity, NavigationFragment.class, null);
                transaction.commit();
            }
        });
    }
    public void transaction(int pos) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        switch (pos){
            case 0:
            case 1:
            case 2:
                break;
        }
    }
}