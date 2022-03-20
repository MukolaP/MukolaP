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
    ArrayAdapter<String> adapter_search;
    ListView listView, notes;
    EditText editText;

    NotesController notesController = new NotesController();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_notes, null);

        Button back_to_main = view.findViewById(R.id.back_notes);
        navigation(back_to_main, 0);

        Button bt_newNotes = view.findViewById(R.id.bt_newNotes);
        navigation(bt_newNotes, 1);

        notes = (ListView) view.findViewById(R.id.Notes_listview);

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
                mam();
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
        adapter_search.notifyDataSetChanged();
    }

    public final void initList() {
        items = new String[]{"Calculator", "Color helper", "Notes"};
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter_search = new ArrayAdapter<>(getContext(), R.layout.list_item_main, R.id.text_item_main, listItems);
        listView.setAdapter(adapter_search);
    }

    @SuppressLint("NonConstantResourceId")
    public final void navigation(Button button, int pos) {
        button.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            switch (pos){
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
        switch (pos){
            case 0:
            case 1:
            case 2:
                break;
        }
    }

    public void mam(){
        ArrayList<String> listItems = new ArrayList<>(Arrays.asList(notesController.getThemes()));
        ArrayAdapter<String> adapter_search = new ArrayAdapter<>(getContext(), R.layout.list_item_main, R.id.text_item_main, listItems);
        notes.setAdapter(adapter_search);
    }
}