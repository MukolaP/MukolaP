package com.example.ultraproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CHRelatedFragment extends Fragment implements View.OnClickListener{
    private Button back_to_main;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c_h_related, null);

        back_to_main = view.findViewById(R.id.back);
        back_to_main.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.back:
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.MainActivity, NavigationFragment.class, null);
                transaction.commit();
        }
    }
}