package com.example.ultraproject.Search;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ultraproject.R;

import java.util.ArrayList;

public class Search extends Fragment {

    private ArrayAdapter<String> adapter_search;

    public final void Search(Context context, ListView listView, EditText editText_search, ArrayList<String> listItems) {

        initList(context, listView, listItems);
        listView.setOnItemClickListener((parent, view1, position, id) -> transaction(position));
        listView.setVisibility(View.INVISIBLE);

        editText_search.addTextChangedListener(new TextWatcher() {

            @Override
            public final void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public final void onTextChanged(CharSequence s, int start, int before, int count) {
                listView.setVisibility(View.VISIBLE);
                if (s.toString().equals("")) {
                    initList(context, listView, listItems);
                    listView.setVisibility(View.INVISIBLE);
                } else {
                    adapter_search.getFilter().filter(s);

                }
            }

            @Override
            public final void afterTextChanged(Editable s) {
            }

        });
    }

    public final void initList(Context context, ListView listView, ArrayList<String> listItems) {
        adapter_search = new ArrayAdapter<>(context,
                R.layout.list_item_main, R.id.text_item_main, listItems);
        listView.setAdapter(adapter_search);
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
